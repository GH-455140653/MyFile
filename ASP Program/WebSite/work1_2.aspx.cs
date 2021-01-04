using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class work1_2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            for(int i = 1; i <= 9; i++)
            {
                for(int j = 1; j <= 9; j++)
                {
                    if (j <= i)
                    {
                        Response.Write(i+"×"+j+"="+i*j);
                        Response.Write("&nbsp;");
                        if (i == j)
                        {
                            Response.Write("<br>");
                        }
                    }
                }
            }
        }
    }
}