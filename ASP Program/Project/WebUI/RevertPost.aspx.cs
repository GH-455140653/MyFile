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
    public partial class RevertPost : System.Web.UI.Page
    {
        ReplayBLL replayBll = new ReplayBLL();
        Revert replay = new Revert();
        User user = new User();
        UserBLL userBll = new UserBLL();
        PostBLL postBll = new PostBLL();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Master.Description.Text = "回复帖子";
                (Master.FindControl("lbDescription") as Label).Text = "回复帖子";
                if (Session["Role"] == null)
                {
                    Response.Redirect("limitRole.aspx");
                }
                else
                {
                    try
                    {
                        Data_Bind();//数据绑定
                    }
                    catch
                    {
                        Page.ClientScript.RegisterStartupScript(this.GetType(), "异常", "<script>alert('操作异常')</script>");
                    }
                }
            }
        }

        /// <summary>
        /// 对帖子名称进行绑定，并显示发帖人的信息
        /// </summary>
        public void Data_Bind()
        {
            string strName = "";
            int userId;
            strName = Session["Name"].ToString();
            userId = int.Parse(Session["userId"].ToString().Trim());
            user = userBll.GetUserByuserId(userId);
            lbName.Text = strName;
            lbEmail.Text = user.UserEmail;
            lbSex.Text = user.UserSex;
            if (user.UserRole == "0")
            {
                lbRole.Text = "管理员";
            }
            else if (user.UserRole == "1")
            {
                lbRole.Text = "会员";
            }
            else if (user.UserRole == "2")
            {
                lbRole.Text = "版主";
            }
            imgPhoto.ImageUrl = "~/images/photo/" + user.UserPhoto;
            int postId = Convert.ToInt32(Request.QueryString["postID"].ToString());
            Post post = postBll.GetPostByPostId(postId);
            postName.Text = post.PostTitle;
        }
        //提交按钮
        protected void Button1_Click(object sender, EventArgs e)
        {
            if (FreeTextBox1.Text == "")
            {
                Page.ClientScript.RegisterStartupScript(this.GetType(), "空值", "<script>alert('回帖内容不能为空！')</script>");
                return;
            }
            else
            {
                try
                {
                    replay.PostID = Convert.ToInt32(Request.QueryString["postID"].ToString());
                    replay.RevertTitle = RevertName.Text;
                    replay.UserID = int.Parse(Session["userId"].ToString().Trim());
                    replay.RevertContent = FreeTextBox1.Text;
                    replay.RevertDate = DateTime.Now;
                    if (replayBll.CreateReplay(replay))
                    {
                        Response.Redirect("postInfo.aspx?postID=" + replay.PostID);
                    }
                    else
                    {
                        Session["errorMsg"] = "请检查操作权限！";
                        Response.Redirect("errorPage.aspx");
                    }
                }
                catch
                {
                    Page.ClientScript.RegisterStartupScript(this.GetType(), "异常", "<script>alert('操作异常！')</script>");
                }
            }
        }
    }
}