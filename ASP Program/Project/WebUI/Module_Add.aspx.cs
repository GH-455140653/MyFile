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
    public partial class Module_Add : System.Web.UI.Page
    {
        ModuleBLL moduleBll = new ModuleBLL();
        Module module = new Module();

        protected void Page_Load(object sender, EventArgs e)
        {
            // Master.Description.Text = "添加版块";
            (Master.FindControl("lbDescription") as Label).Text = "添加版块";

        }
        protected void btnAdd_Click(object sender, EventArgs e)
        {
            module.ModuleName = txtName.Text.Trim();
            module.ModuleIntro = txtIntro.Text.Trim();
            module.BuildDate = DateTime.Now;
            if (moduleBll.CreateModule(module))
            {
                Response.Write("<script>alert('添加成功！')</script>");
                Response.Redirect("ModuleList.aspx");
            }
            else
            {
                Response.Redirect("errorPage.aspx");
            }
        }
        protected void btnCancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("ModuleList.aspx");
        }
    }
}