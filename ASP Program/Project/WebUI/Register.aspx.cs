using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;

using BLL;
using Model;


namespace WebUI
{
    public partial class Register : System.Web.UI.Page
    {
        UserBLL userBll = new UserBLL();
        ArrayList arr = new ArrayList();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Master.Description.Text = "用户注册";
                (Master.FindControl("lbDescription") as Label).Text = "用户注册";
            }
        }
        protected void btnAdd_Click(object sender, EventArgs e)
        {
            User user = new User();
            try
            {
                user.UserName = txtName.Text.Trim();
                user.UserPswd = txtPswd.Text.Trim();
                user.UserAge = int.Parse(txtAge.Text.Trim());
                user.UserPhoto = drPhoto.SelectedItem.Value.ToString();
                user.UserEmail = txtEmail.Text.Trim();
                user.UserRole = "1";
                if (rbtnBoy.Checked == true)
                {
                    user.UserSex = "男";
                }
                if (rbtnGril.Checked == true)
                {
                    user.UserSex = "女";
                }
                user.UserAddress = txtAddr.Text.Trim();
                if (userBll.CreateUser(user))
                {
                    Response.Redirect("index.aspx");
                }
                else
                {
                    Response.Redirect("errorPage.aspx");
                }
            }
            catch (Exception ex)
            {

                Page.ClientScript.RegisterStartupScript(this.GetType(), "script", "<script>alert('" + ex.Message + "')</script>");

            }
        }
        protected void drPhoto_SelectedIndexChanged(object sender, EventArgs e)
        {
            imgUser.ImageUrl = "~/images/Photo/" + drPhoto.SelectedItem.Value.ToString();
        }
        protected void btnCancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("index.aspx");
        }

        protected void CustomValidator1_Load(object sender, EventArgs e)
        {

        }

        protected void CustomValidator1_Init(object sender, EventArgs e)
        {
            DataSet ds = userBll.GetUsers();
            if (ds.Tables != null)
            {
                for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                {
                    arr.Add(ds.Tables[0].Rows[i]["userName"]);
                }
            }
        }

        protected void CustomValidator1_ServerValidate(object source, ServerValidateEventArgs args)
        {
            string name = txtName.Text.ToString();
            if (name != null)
            {
                for (int i = 0; i < arr.Count; i++)
                {
                    if (arr[i] == txtName)
                    {
                        args.IsValid = true;
                        break;
                    }
                    else
                    {
                        args.IsValid = false;
                    }
                }
            }
        }


        protected override void OnPreRender(EventArgs args)//textbox属性textboxmode="password"时，页面刷新，回传
        {
            base.OnPreRender(args);
            this.txtPswd.Attributes["value"] = txtPswd.Text;
            this.txtPswd2.Attributes["value"] = txtPswd2.Text;
        }
    }
}