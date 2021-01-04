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


namespace WebUI
{
    public partial class errorPage : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lbText.Text = "操作出现异常！" + Session["errorMsg"];
        }
    }
}