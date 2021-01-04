using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class exam1_7 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btn_submit_Click(object sender, EventArgs e)
        {
            //bool flag = false;
            if (FileUpload1.HasFile)
            {
                //文件后缀判断
                string fileExtension = System.IO.Path.GetExtension(FileUpload1.FileName).ToLower();
                //定义后缀判断数组
                string[] extensionName = { ".gif", ".jpg", ".bmp", ".png" };
                //后缀循环遍历判断
                for (int i = 0; i < extensionName.Length; i++)
                {
                    if (fileExtension == extensionName[i])
                    {
                        //flag = true;
                        //后缀正确实现上传
                        try
                        {
                            //拼接服务端存储绝对路径
                            string path = Server.MapPath("./") + "upload" + "\\" + FileUpload1.FileName;
                            //判断图片的存在性
                            if (File.Exists(path))
                            {
                                fileMsg.Text = "图片已存在！";
                            }
                            else
                            {
                                //文件上传并显示相关信息
                                FileUpload1.SaveAs(path);
                                //fileMsg.Text = "";//清空已有的文本信息（避免上次失败信息残留）
                                fileMsg.Text = "上传成功！<br/>";
                                fileMsg.Text += "上传文件名称：" + FileUpload1.FileName + "<br/>";
                                fileMsg.Text += "原文件路径：" + FileUpload1.PostedFile.FileName + "<br/>";
                                fileMsg.Text += "上传文件大小：" + (FileUpload1.PostedFile.ContentLength / 1024).ToString() + "KB" + "<br/>";
                                fileMsg.Text += "上传文件类型：" + FileUpload1.PostedFile.ContentType.ToString() + "<br/>";

                                //显示指定上传照片图像
                                photo.Visible = true;
                                photo.ImageUrl = "~/upload/" + FileUpload1.FileName;

                                //文件上传列表构建
                                RBL_file.Items.Add(FileUpload1.FileName);
                            }
                        }
                        catch (Exception)
                        {
                            System.Console.WriteLine("上传失败");
                        }
                    }
                }
            }
            else
            {
                Response.Write("<script>alert('只能够上传后缀为.gif,.jpg,.bmp,.png 的文件')</script>");
            }
        }

        protected void RBL_file_Click(object sender, BulletedListEventArgs e)
        {
            string costmer_click = RBL_file.Items[e.Index].Text;
            string path = Server.MapPath("./") + "upload" + "\\" + costmer_click;
            FileInfo fileInfo = new FileInfo(path);
            Response.Clear();
            Response.AddHeader("content-disposition", "attachment;filename=" + Server.UrlEncode(fileInfo.Name.ToString()));//文件名 
            Response.AddHeader("content-length", fileInfo.Length.ToString());//文件大小 
            Response.ContentType = "application/octet-stream";
            Response.ContentEncoding = System.Text.Encoding.Default;
            Response.WriteFile(path);
        }
    }
}