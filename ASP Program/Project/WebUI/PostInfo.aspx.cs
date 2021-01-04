using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;

using BLL;
using Model;


namespace WebUI
{
    public partial class PostInfo : System.Web.UI.Page
    {
        ReplayBLL replayBll = new ReplayBLL();
        PostBLL postBll = new PostBLL();
        UserBLL userBll = new UserBLL();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                this.dataBind();
                // Master.Description.Text = "帖子详细信息";
                (Master.FindControl("lbDescription") as Label).Text = "帖子详细信息";
            }
        }
        /// <summary>
        /// 数据绑定
        /// </summary>
        public void dataBind()
        {
            if (Request.QueryString["postID"] != null)
            {
                int postID = Convert.ToInt32(Request.QueryString["postID"].ToString());
                postBd(postID);
                DataListBd(postID);
            }
        }

        public void postBd(int postID)
        {
            Post post = postBll.GetPostByPostId(postID);
            User user = userBll.GetUserByuserId(post.UserID);
            lbUserName.Text = user.UserName;
            lbPostTitle.Text = post.PostTitle;
            lbDateTime.Text = post.PostDate.ToString();
            lbpostContent.Text = post.PostContent;
            imgUser.ImageUrl = "~/images/photo/" + user.UserPhoto;
        }

        public void DataListBd(int postID)
        {
            DataSet ds = replayBll.getRevertByPostId(postID);//根据帖子编号查询回帖信息
            if (ds != null)
            {

                int curpage = Convert.ToInt32(labPage.Text);
                PagedDataSource ps = new PagedDataSource();
                ps.DataSource = ds.Tables[0].DefaultView;
                ps.AllowPaging = true;
                ps.PageSize = 2;
                ps.CurrentPageIndex = curpage - 1;//取得当前页的页码
                lnkbtnBack.Enabled = true;
                lnkbtnNext.Enabled = true;
                lnkbtnOne.Enabled = true;
                lnkbtnUp.Enabled = true;
                if (curpage == 1)
                {
                    lnkbtnOne.Enabled = false;
                    lnkbtnUp.Enabled = false;
                }
                if (curpage == ps.PageCount)
                {
                    lnkbtnNext.Enabled = false;
                    lnkbtnBack.Enabled = false;
                }
                this.labBackPage.Text = Convert.ToString(ps.PageCount);
                datalistInfo.DataKeyField = "RevertID";
                datalistInfo.DataSource = ps;
                datalistInfo.DataBind();
            }
            else
            {
                datalistInfo.DataSource = null;
                datalistInfo.DataBind();
                lbError.Text = "还没有回复此帖子，快来抢沙发吧！";
                lnkbtnBack.Enabled = false;
                lnkbtnNext.Enabled = false;
                lnkbtnOne.Enabled = false;
                lnkbtnUp.Enabled = false;
            }
        }

        /// <summary>
        /// 根据回帖编号获取回帖人的头像
        /// </summary>
        /// <param name="str"></param>
        /// <returns></returns>
        public string GetPhoto(string str)
        {
            int userID = Convert.ToInt32(str);
            User user = userBll.GetUserByuserId(userID);
            string userPhoto = user.UserPhoto;
            return userPhoto;
        }

        public string GetUserName(string str)//获取回帖人姓名
        {
            int userID = Convert.ToInt32(str);
            User user = userBll.GetUserByuserId(userID);
            string userName = user.UserName;
            return userName;
        }
        /// <summary>
        /// 如果是版主和管理员，则可以删除回复的帖子
        /// </summary>
        /// <param name="source"></param>
        /// <param name="e"></param>
        protected void datalistInfo_DeleteCommand(object source, DataListCommandEventArgs e)
        {
            if (Session["Role"] != null)
            {
                if (Session["Role"].ToString() == "0" || Session["Role"].ToString() == "2")
                {
                    int RevertID = Convert.ToInt32(datalistInfo.DataKeys[e.Item.ItemIndex].ToString());//获取当前DataList控件列
                    if (replayBll.DelReplay(RevertID))
                    {
                        Response.Write("<script>alert('删除成功！')</script>");
                        labPage.Text = "1";
                        this.dataBind();
                    }
                    else
                    {
                        Response.Redirect("errorPage.aspx");
                    }
                }
                else
                {
                    Response.Redirect("limitRole.aspx");
                }
            }
            else
            {
                Response.Redirect("limitRole.aspx");
            }
        }
        public void pageCount()
        {
            if (Page.Request["postID"] != null)
            {
                DataListBd(Convert.ToInt32(Request["postID"].ToString()));
                return;
            }
        }
        protected void lnkbtnOne_Click(object sender, EventArgs e)
        {
            labPage.Text = "1";
            pageCount();
        }
        protected void lnkbtnUp_Click(object sender, EventArgs e)
        {
            labPage.Text = Convert.ToString(Convert.ToInt32(labPage.Text) - 1);
            pageCount();
        }
        protected void lnkbtnNext_Click(object sender, EventArgs e)
        {
            labPage.Text = Convert.ToString(Convert.ToInt32(labPage.Text) + 1);
            pageCount();
        }
        protected void lnkbtnBack_Click(object sender, EventArgs e)
        {
            labPage.Text = labBackPage.Text;
            pageCount();
        }
        protected void LinkButton1_Click(object sender, EventArgs e)
        {

            if (Request.QueryString["postID"].ToString() != null)
            {
                int postID = Convert.ToInt32(Request.QueryString["postID"].ToString());
                Response.Redirect("RevertPost.aspx?postID=" + postID);
            }
        }
    }
}