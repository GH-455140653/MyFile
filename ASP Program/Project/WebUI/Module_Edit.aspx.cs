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
    public partial class Module_Edit : System.Web.UI.Page
    {
        ModuleBLL moduleBll = new ModuleBLL();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int moduleId = int.Parse(Request.QueryString["moduleId"].ToString());
                Module module = moduleBll.GetModuleById(moduleId);
                txtName.Text = module.ModuleName;
                txtIntro.Text = module.ModuleIntro;
                // Master.Description.Text = "修改版块";
                (Master.FindControl("lbDescription") as Label).Text = "修改版块";
            }
        }
        protected void btnAdd_Click(object sender, EventArgs e)
        {
            Module module = new Module();
            int moduleId = int.Parse(Request.QueryString["moduleId"].ToString());
            module.ModuleID = moduleId;
            module.ModuleName = txtName.Text;
            module.ModuleIntro = txtIntro.Text;
            module.BuildDate = DateTime.Now;
            if (moduleBll.UpdateModule(module))
            {
                Response.Write("<script>alert('更新成功！')</script>");
                Response.Redirect("moduleList.aspx");
            }
            else
            {
                Response.Redirect("errorPage.aspx");
            }
        }
        //取消按钮
        protected void btnCancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("ModuleList.aspx");
        }
    }
}