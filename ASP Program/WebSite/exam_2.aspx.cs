using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class exam_2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            rv_bornDate.MaximumValue = DateTime.Now.ToShortDateString();
            rv_bornDate.Text = "日期应在1900/1/1到" + rv_bornDate.MaximumValue + "之间！";
        }

        protected void btn_submit_Click(object sender, EventArgs e)
        {
            if (Page.IsValid)
            {
                Response.Write("<script>alert('注册成功！')</script>");
            }
        }

        protected void btn_reset_Click(object sender, EventArgs e)
        {
            btn_reset.Attributes.Add("onclick", "{javascript:FormId.reset();return   false;}");
        }
    }
}