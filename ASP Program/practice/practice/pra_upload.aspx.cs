using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace practice
{
    public partial class pra_upload : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if (FileUpload1.HasFile)
            {
                Label1.Text = "文件名：" + FileUpload1.FileName;
                string path = Server.MapPath("~/" + "\\upload\\");
                FileUpload1.SaveAs(path + FileUpload1.FileName);
                Label1.Text += "上传文件大小：" + FileUpload1.PostedFile.ContentLength / 1024 + "kB</br>";
                Label1.Text += "上传文件类型：" + FileUpload1.PostedFile.ContentType;
            }
            else
            {
                Response.Write("<script>alert('请选择文件')</script>");
            }
        }
    }
}