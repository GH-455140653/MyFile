using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebSite
{
    public partial class exam1_4 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                bindCollege();
                bindClass();
                bindStudent();
            }
        }
        protected void bindCollege()
        {
            DLCollege.Items.Add("请选择");
            DLCollege.Items.Add("计算机与信息技术学院");
            DLCollege.Items.Add("外国语学院");
            DLCollege.Items.Add("法学院");
            DLCollege.Items.Add("数学与统计学院");
        }

        protected void bindClass()
        {
            DLClass.Items.Add("软工18-2");
            DLClass.Items.Add("俄语18-1");
            DLClass.Items.Add("法律18-1");
            DLClass.Items.Add("应数18-1");
            DLClass.Items.Add("计科18-1");
        }

        protected void bindStudent()
        {
            DLName.Items.Add("张三");
            DLName.Items.Add("李四");
            DLName.Items.Add("王五");
            DLName.Items.Add("薛一");
            DLName.Items.Add("lrl");
            DLName.Items.Add("jack");
        }

        protected void DLCollege_SelectedIndexChanged(object sender, EventArgs e)
        {
            switch (DLCollege.SelectedIndex)
            {
                case 0:
                    {
                        DLClass.Items.Clear();
                        DLName.Items.Clear();
                    }
                    break;
                case 1:
                    {
                        DLClass.Items.Clear();
                        DLClass.Items.Add("请选择");
                        DLClass.Items.Add("计科18-1");
                        DLClass.Items.Add("软工18-2");
                    }
                    break;
                case 2:
                    {
                        DLClass.Items.Clear();
                        DLClass.Items.Add("请选择");
                        DLClass.Items.Add("俄语18-1");
                    }
                    break;
                case 3:
                    {
                        DLClass.Items.Clear();
                        DLClass.Items.Add("请选择");
                        DLClass.Items.Add("法律18-1");
                    }
                    break;
                case 4:
                    {
                        DLClass.Items.Clear();
                        DLClass.Items.Add("请选择");
                        DLClass.Items.Add("应数18-1");
                    }
                    break;
            }
        }

        protected void DLClass_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (DLCollege.SelectedIndex != 0)
            {
                switch (DLClass.SelectedValue)
                {
                    case "软工18-2":
                        {
                            DLName.Items.Clear();
                            DLName.Items.Add("lrl");
                            DLName.Items.Add("王五");
                        }
                        break;
                    case "俄语18-1":
                        {
                            DLName.Items.Clear();
                            DLName.Items.Add("jack");
                        }
                        break;
                    case "法律18-1":
                        {
                            DLName.Items.Clear();
                            DLName.Items.Add("张三");
                        }
                        break;
                    case "计科18-1":
                        {
                            DLName.Items.Clear();
                            DLName.Items.Add("薛一");
                        }
                        break;
                    case "应数18-1":
                        {
                            DLName.Items.Clear();
                            DLName.Items.Add("李四");
                        }
                        break;
                    default:
                        DLName.Items.Clear();
                        break;
                }
            }
        }

        protected void DLClass_TextChanged(object sender, EventArgs e)
        {
        }

        protected void DLName_TextChanged(object sender, EventArgs e)
        {

        }
    }
}