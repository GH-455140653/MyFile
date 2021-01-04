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
    public partial class Index : System.Web.UI.Page
    {
        ModuleBLL moduleBll = new ModuleBLL();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                (Master.FindControl("lbDescription") as Label).Text = "版块信息";
                DataSet ds = moduleBll.GetModule();
                if (ds != null && ds.Tables[0].Rows.Count > 0)
                {
                    dataListInfo.DataSource = ds.Tables[0].DefaultView;
                    dataListInfo.DataBind();
                }
            }
        }
    }
}