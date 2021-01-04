using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class hw_2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }
        protected void Page_PreInit(object sender, EventArgs e)
        {
            string theme="hw2_1";
            if (Request.QueryString["Theme"] == null)
            {
                theme = "hw2_1";
                TextBox1.Text = "主题一";
                TextBox2.Text = "主题一";
            }
            else
            {
                theme = Request.QueryString["Theme"];
                if (theme.ToString().Equals("hw2_1"))
                {
                    TextBox1.Text = "主题一";
                    TextBox2.Text = "主题一";
                }
                else
                {
                    TextBox1.Text = "主题二";
                    TextBox2.Text = "主题二";
                }
            }
            Page.Theme = theme;
            ListItem flag = DropDownList1.Items.FindByValue(theme);
            if (flag != null)
            {
                flag.Selected = true;
            }
        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string url = Request.Path + "?Theme=" + DropDownList1.SelectedItem.Value;
            Response.Redirect(url);

        }
    }
}