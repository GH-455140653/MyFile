using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class work1_3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void Button_Click(object sender, EventArgs e)
        {
            string str = input.Text;
            string[] arr = str.Split(' ');
            int[] arr_i = new int[arr.Length];

            //字符串转换
            for(int i = 0; i < arr.Length; i++)
            {
                arr_i[i] = Convert.ToInt32(arr[i]);
            }

            //冒泡排序
            for(int i = 0; i < arr_i.Length; i++)
            {
                for(int j = 0; j < i; j++)
                {
                    if (arr_i[i] > arr_i[j])
                    {
                        int temp;
                        temp = arr_i[i];
                        arr_i[i] = arr_i[j];
                        arr_i[j] = temp;
                    }
                }
            }

            //字符串输出
            string line="";
            foreach (int s in arr_i)
            {
                line = line + s + "&nbsp;";
            }
            output.Text = line;
        }
    }
}