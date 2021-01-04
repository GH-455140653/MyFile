using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (this.IsPostBack == false)
            {
                ListBox1.Items.Add("星期一");
                ListBox1.Items.Add("星期二");
                ListBox1.Items.Add("星期三");
                ListBox1.Items.Add("星期四");
                ListBox1.Items.Add("星期五");
                ListBox1.Items.Add("星期六");
                ListBox1.Items.Add("星期日");
            }
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            for(int i = 0; i < ListBox1.Items.Count; i++)
            {
                ListBox2.Items.Add(ListBox1.Items[i].Text.ToString());
            }
            ListBox1.Items.Clear();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < ListBox2.Items.Count; i++)
            {
                ListBox1.Items.Add(ListBox2.Items[i].Text.ToString());
            }
            ListBox2.Items.Clear();
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            for(int i = 0; i < ListBox1.Items.Count; i++)
            {
                if (ListBox1.Items[i].Selected == true)
                {
                    ListBox2.Items.Add(ListBox1.Items[i].ToString());
                    ListBox1.Items.Remove(ListBox1.Items[i].ToString());
                    i--;
                }
            }
        }

        protected void Button4_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < ListBox2.Items.Count; i++)
            {
                if (ListBox2.Items[i].Selected == true)
                {
                    ListBox1.Items.Add(ListBox2.Items[i].ToString());
                    ListBox2.Items.Remove(ListBox2.Items[i].ToString());
                    i--;
                }
            }
        }
    }
}