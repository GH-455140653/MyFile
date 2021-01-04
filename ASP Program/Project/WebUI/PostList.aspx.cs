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
    public partial class PostList : System.Web.UI.Page
    {
        UserBLL userBll = new UserBLL();
        ModuleBLL ModuleBll = new ModuleBLL();
        PostBLL postBll = new PostBLL();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                this.DataListBd();
                // Master.Description.Text = "帖子信息";
                (Master.FindControl("lbDescription") as Label).Text = "帖子信息";
            }
        }
        public void DataListBd()
        {
            int ModuleID = Convert.ToInt32(Request.QueryString["ModuleID"].ToString());

            DataSet ds = postBll.GetPostByModuleId(ModuleID);
            if (ds != null)
            {
                int curpage = Convert.ToInt32(labPage.Text);
                PagedDataSource ps = new PagedDataSource();
                ps.DataSource = ds.Tables[0].DefaultView;
                ps.AllowPaging = true;//是否可以分页
                ps.PageSize = 2;//每页显示的数量
                ps.CurrentPageIndex = curpage - 1;//设置当前页的索引
                lnkbtnUp.Enabled = true;
                lnkbtnNext.Enabled = true;
                lnkbtnBack.Enabled = true;
                lnkbtnOne.Enabled = true;
                if (curpage == 1)
                {
                    lnkbtnOne.Enabled = false;//不显示第一页按钮
                    lnkbtnUp.Enabled = false;//不显示上一页按钮

                }
                if (curpage == ps.PageCount)
                {
                    lnkbtnNext.Enabled = false;//不显示下一页
                    lnkbtnBack.Enabled = false;//不显示最后一页
                }
                this.labCountPage.Text = Convert.ToString(ps.PageCount);//最后一页
                dataListInfo.DataKeyField = "postID";
                dataListInfo.DataSource = ps;
                dataListInfo.DataBind();
            }
            else
            {
                dataListInfo.DataSource = null;
                dataListInfo.DataBind();
                lbError.Text = "还没有人在此版块发表帖子，你赶紧发表吧！";
                lnkbtnBack.Enabled = false;
                lnkbtnNext.Enabled = false;
                lnkbtnOne.Enabled = false;
                lnkbtnUp.Enabled = false;
            }
        }
        protected void lnkbtnOne_Click(object sender, EventArgs e)
        {
            labPage.Text = "1";
            this.DataListBd();
        }
        protected void lnkbtnUp_Click(object sender, EventArgs e)//上一页
        {
            labPage.Text = Convert.ToString(Convert.ToInt32(labPage.Text) - 1);
            this.DataListBd();
        }
        protected void lnkbtnNext_Click(object sender, EventArgs e)//下一页
        {
            labPage.Text = Convert.ToString(Convert.ToInt32(labPage.Text) + 1);
            this.DataListBd();
        }
        protected void lnkbtnBack_Click(object sender, EventArgs e)
        {
            labPage.Text = labCountPage.Text;
            this.DataListBd();
        }
        protected void dataListInfo_DeleteCommand(object source, DataListCommandEventArgs e)
        {
            if (Session["Role"] != null)
            {
                if (Session["Role"].ToString() == "0" || Session["Role"].ToString() == "2")
                {
                    int PostID = Convert.ToInt32(dataListInfo.DataKeys[e.Item.ItemIndex].ToString());//获取当前DataList控件列
                     if (postBll.DelPost(PostID))
                    {
                        Response.Write("<script>alert('删除成功！')</script>");
                        labPage.Text = "1";
                        this.DataListBd();
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
    }
}