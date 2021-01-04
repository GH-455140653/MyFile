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
    public partial class User_Edit : System.Web.UI.Page
    {
        UserBLL userBll = new UserBLL();
        User user = new User();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                this.DataBd();
                // Master.Description.Text = "修改用户信息";
                (Master.FindControl("lbDescription") as Label).Text = "修改用户信息";
            }

        }
        void DataBd()
        {
            if (Request.QueryString["userId"] != null)
            {
                int userId = Convert.ToInt32(Request.QueryString["userId"].ToString());
                user = userBll.GetUserByuserId(userId);
                if (user != null)
                {
                    lbName.Text = user.UserName;
                    txtAge.Text = user.UserAge.ToString();
                    txtAddr.Text = user.UserAddress;
                    txtEmail.Text = user.UserEmail;
                    // txtPswd.Text = txtPswd2.Text = user.UserPswd;
                    txtp1.Text = user.UserPswd;
                    txtp2.Text = user.UserPswd;
                    //txtPswd.Text = user.UserPswd;
                    //txtPswd2.Text = user.UserPswd;
                    if (user.UserSex == "男")
                        rbtnBoy.Checked = true;
                    if (user.UserSex == "女")
                        rbtnGril.Checked = true;
                    drPhoto.Text = user.UserPhoto;
                    imgUser.ImageUrl = "~/images/photo/" + user.UserPhoto;
                }
                else
                {
                    Response.Redirect("errorPage.aspx");
                }
            }
            else
            {
                Response.Redirect("limitRole.aspx");
            }
        }

        //修改用户信息
        protected void btnAdd_Click(object sender, EventArgs e)
        {
            int userId = Convert.ToInt32(Request.QueryString["userId"].ToString());
            user.UserID = userId;
            user.UserPswd = txtp1.Text.Trim();
            user.UserAge = int.Parse(txtAge.Text.Trim());
            user.UserAddress = txtAddr.Text;
            user.UserEmail = txtEmail.Text;
            if (rbtnBoy.Checked)
                user.UserSex = "男";
            else
                user.UserSex = "女";
            user.UserPhoto = drPhoto.SelectedItem.Value.ToString();
            if (rbtnAdmin.Checked)
                user.UserRole = "0";
            else
                if (rbtnBz.Checked)
                user.UserRole = "2";
            else
                user.UserRole = "1";
            if (userBll.UpdateUser(user))
                Response.Redirect("userList.aspx");
            else
                Response.Redirect("errorPage.aspx");
        }
        protected void btnCancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("index.aspx");
        }
        protected void drPhoto_SelectedIndexChanged(object sender, EventArgs e)
        {
            imgUser.ImageUrl = "~/images/Photo/" + drPhoto.SelectedItem.Value.ToString();
        }
    }
}