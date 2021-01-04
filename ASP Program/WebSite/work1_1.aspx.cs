using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class work1_1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void input_TextChanged(object sender, EventArgs e)
        {
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            int key = Convert.ToInt32(input.Text);
            if (key >= 90)
            {
                Label.Text = "优秀";
            }
            else
            {
                Label.Text = "";
            }
        }
    }
}