using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class exam_6 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Label lblQuestion1 = new Label();
            lblQuestion1.ID = "iblQuestion1";
            lblQuestion1.Text = "1.Web服务器控件不包括（）。";
            PlaceHolder1.Controls.Add(lblQuestion1);
            RadioButtonList rdoltChoice1 = new RadioButtonList();
            rdoltChoice1.ID = "rdoltChoice1";
            rdoltChoice1.Items.Add(new ListItem("A.Wizard", "A"));
            rdoltChoice1.Items.Add(new ListItem("B.input", "B"));
            rdoltChoice1.Items.Add(new ListItem("C.Adrotator", "C"));
            rdoltChoice1.Items.Add(new ListItem("D.Calender", "D"));
            PlaceHolder1.Controls.Add(rdoltChoice1);
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            RadioButtonList rdoltChoice1 = (RadioButtonList)PlaceHolder1.FindControl("rdoltChoice1");
            if (rdoltChoice1.Text.ToString() == "")
            {
                Response.Write("<script>alert('请选择你的答案再点提交')</script>");
            }
            else
            {
                Label1.Text = "你选择了：" + rdoltChoice1.SelectedValue;
            }
        }
    }
}