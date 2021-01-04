using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class pra_1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btn_upload_Click(object sender, EventArgs e)
        {
            if (FUL.HasFile)
            {
                uploadLB.Text = "文件名称：" + FUL.FileName;
                string path = Server.MapPath("~/"+"\\upload\\");
                FUL.SaveAs(path + FUL.FileName);
            }
            else
            {
                Response.Write("<script>alert('请选择文件！')</script>");
            }
        }
    }
}