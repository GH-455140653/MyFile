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
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                (Master.FindControl("lbDescription") as Label).Text = "用户登录";
            }
        }
        protected void btnLogin_Click(object sender, EventArgs e)
        {

            UserBLL userBll = new UserBLL();
            string userName = txtName.Text.Trim();
            string userPassword = txtPswd.Text.Trim();
            try
            {
                DataSet ds = userBll.GetUser(userName, userPassword);
                if (Session["checkCode"].ToString() != txtCode.Text.Trim())
                {
                    lbError.Text = "验证码错误，请重新输入";
                }
                else
                if (ds != null && ds.Tables[0].Rows.Count > 0)
                {
                    Session["Role"] = ds.Tables[0].Rows[0]["userRole"].ToString();
                    Session["userId"] = Convert.ToInt32(ds.Tables[0].Rows[0]["userID"].ToString());
                    Session["Name"] = userName;
                    Response.Redirect("index.aspx");
                }
                else
                {
                    lbError.Text = "用户名和密码不匹配，请重新输入！";
                    txtName.Focus();
                    txtName.Text = "";
                    txtPswd.Text = "";
                    txtCode.Text = "";
                }
            }
            catch (Exception ex)
            {
                Page.ClientScript.RegisterStartupScript(this.GetType(), "script", "<script>alert('" + ex.Message + "')</script>");
            }
        }
        protected void btnCancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("index.aspx");
        }
        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            IbtnCode.ImageUrl = "~/ValidateCode.aspx";
        }

        protected void Button_1(object sender, EventArgs e)
        {
            IbtnCode.ImageUrl = "~/ValidateCode.aspx";
        }
    }
}