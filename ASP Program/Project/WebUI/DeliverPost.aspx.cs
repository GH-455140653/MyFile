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
    public partial class DeliverPost : System.Web.UI.Page
    {
        Post post = new Post();
        User user = new User();
        PostBLL postBll = new PostBLL();
        UserBLL userBll = new UserBLL();
        ModuleBLL moduleBll = new ModuleBLL();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                (Master.FindControl("lbDescription") as Label).Text = "发表帖子";
                if (Session["Role"] == null)
                {
                    Response.Redirect("limitRole.aspx");
                }
                else
                {
                    try
                    {
                        Drp_Bind();
                        User_Bind();
                    }
                    catch (Exception)
                    {
                        Page.ClientScript.RegisterStartupScript(this.GetType(), "异常", "<script>alert('操作异常')</script>");
                    }
                }
            }
        }
        /// <summary>
        /// 绑定下拉菜单
        /// </summary>
        public void Drp_Bind()
        {
            DataSet ds = moduleBll.GetModule();
            if (ds != null && ds.Tables[0].Rows.Count > 0)
            {
                ddList.DataSource = ds;
                ddList.DataTextField = "ModuleName";
                ddList.DataValueField = "ModuleID";
                ddList.DataBind();
            }
        }

        /// <summary>
        /// 绑定用户信息
        /// </summary>
        public void User_Bind()
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
        }

        /// <summary>
        /// 提交按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void Button1_Click(object sender, EventArgs e)
        {
            string userName = "";
            string userRole = "";
            if (txtTitle.Text == "")
            {
                Page.ClientScript.RegisterStartupScript(this.GetType(), "异常", "<script>alert('帖子标题不能为空！')</script>");
                return;
            }
            userName = Session["Name"].ToString();
            userRole = Session["Role"].ToString();

            post.PostTitle = txtTitle.Text.Trim();
            post.UserID = int.Parse(Session["userId"].ToString().Trim());
            post.PostContent = FreeTextBox1.Text;
            post.PostDate = DateTime.Now;
            post.ModuleID = Convert.ToInt32(ddList.SelectedValue);

            if (postBll.CreatePost(post))
            {
                Response.Redirect("postList.aspx?ModuleID=" + post.ModuleID);
            }
            else
            {
                Session["errorMsg"] = "请检查你的权限";
                Response.Redirect("errorPage.aspx");
            }
        }
    }
}