using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Xml.Linq;


namespace WebUI
{
    public partial class Site : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "〖" + DateTime.Now.ToString("yyyy年MM月dd日") + " " + DateTime.Today.DayOfWeek.ToString() + "〗";
            this.Login();
        }
        public void Login()
        {
            if (Session["Role"] == null)
            {
                Label2.Text = "您现在是游客身份，只可以浏览帖子！如果想发表或回复信息，请注册/登录！";
                return;
            }
            if (Session["Role"].ToString() == "0")
            {
                Label2.Text = "[" + Session["Name"].ToString() + "]，您现在是本站管理员";
                Panel1.Visible = false;
                Panel2.Visible = false;
                Panel3.Visible = true;
                return;
            }
            if (Session["Role"].ToString() == "1")
            {
                Label2.Text = "[" + Session["Name"].ToString() + "]，您现在是本站会员";
                Panel1.Visible = false;
                Panel2.Visible = true;
                Panel3.Visible = false;
                return;
            }
            if (Session["Role"].ToString() == "2")
            {
                Label2.Text = "[" + Session["Name"].ToString() + "]，您现在是本站版主";
                Panel1.Visible = false;
                Panel2.Visible = true;
                Panel3.Visible = false;
                return;
            }
        }
        public void LoginOut()
        {
            Panel1.Visible = true;
            Panel2.Visible = false;
            Panel3.Visible = false;
            HttpContext.Current.Session.Clear();//清除Session内容
            HttpContext.Current.Session.Abandon();//取消当前会话
            Session["ID"] = null;
            Session["Role"] = null;
            Session["Name"] = null;
            Login();
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            LoginOut();
            Response.Redirect("index.aspx");
        }
    }
}