using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Drawing;
using System.IO;


namespace WebUI
{
    public partial class ValidateCode : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string checkCode = createRandomCode(4);
            Session["checkCode"] = checkCode;
            this.createImage(checkCode);
        }
        private string createRandomCode(int codeCount)
        {
            string str = "1,2,3,4";
            string[] codeChar = str.Split(',');
            string randomCode = "";
            int temp = -1;
            Random r = new Random();
            for (int i = 0; i < codeCount; i++)
            {
                if (temp != -1)
                {
                    r = new Random(i * temp * ((int)DateTime.Now.Ticks));
                }
                int t = r.Next(4);
                if (temp == t)
                {
                    return createRandomCode(codeCount);
                }
                temp = t;
                randomCode += codeChar[t];
            }
            Session["checkCode"] = randomCode;
            return randomCode;
        }

        private void createImage(string randomCode)
        {
            //创建一个图形,也可以直接定义图片的高和宽
            int imageWidth = (int)(randomCode.Length * 25);
            Bitmap image = new Bitmap(imageWidth, 40);
            Graphics g = Graphics.FromImage(image);
            Random rand = new Random();
            //定义颜色
            Color[] c = { Color.Black, Color.Red, Color.DarkBlue, Color.Green, Color.Orange, Color.Brown, Color.DarkCyan, Color.Purple };
            //定义字体 
            string[] font = { "Times New Roman", "楷书", "幼圆", "Arial", "宋体" };
            //输出不同字体和颜色的验证码字符
            g.Clear(Color.White);  //清除原来颜色
            for (int i = 0; i < randomCode.Length; i++)
            {
                int cindex = rand.Next(8);
                int findex = rand.Next(5);
                int sindex = rand.Next(10, 20);

                Font f = new Font(font[findex], sindex, FontStyle.Bold);
                Brush b = new SolidBrush(c[cindex]);
                //指定每一个字符的格式
                int ii = 4;
                if ((i + 1) % 2 == 0)
                {
                    ii = 2;
                }
                g.DrawString(randomCode.Substring(i, 1), f, b, i * 22, ii);
                //第一个参数表示显示的字符，第二、三个参数分别表示字体和颜色，
                //第四个参数表示离原点的距离（x坐标），第五个参数表示纵坐标（y坐标）            
            }
            //画图片的背景噪音线
            for (int i = 0; i < 4; i++)
            {
                int x1 = rand.Next(image.Width);
                int x2 = rand.Next(image.Width);
                int y1 = rand.Next(image.Height);
                int y2 = rand.Next(image.Height);
                g.DrawLine(new Pen(Color.Silver), x1, y1, x2, y2);
            }
            //画图片的前景噪音点
            for (int i = 0; i < 100; i++)
            {
                int x = rand.Next(image.Width);
                int y = rand.Next(image.Height);
                image.SetPixel(x, y, Color.FromArgb(rand.Next()));
            }
            ////画图片的边框线
            g.DrawRectangle(new Pen(Color.Silver), 0, 0, image.Width - 1, image.Height - 1);
            MemoryStream ms = new MemoryStream();
            image.Save(ms, System.Drawing.Imaging.ImageFormat.Jpeg);//将图形以Jpeg格式保存到ms流中
            Response.ClearContent();//清除缓冲区的所有输出
            Response.ContentType = "image/Jpeg";//获取输出流的类型为Jpeg图片
            Response.BinaryWrite(ms.ToArray());
            g.Dispose();
            image.Dispose();
        }
    }
}