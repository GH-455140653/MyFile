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
    public partial class UserList : System.Web.UI.Page
    {
        UserBLL userBll = new UserBLL();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                this.GridViewBd();
                // Master.Description.Text = "用户信息";
                (Master.FindControl("lbDescription") as Label).Text = "用户信息";
            }

        }
        void GridViewBd()
        {
            gvInfo.DataSource = userBll.GetUsers().Tables[0].DefaultView;
            gvInfo.DataBind();
        }

        //在GridView控件中实现修改和删除功能
        protected void gvInfo_RowCreated(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                LinkButton lnkbtnDel = (LinkButton)e.Row.FindControl("lnkbtnDel");
                LinkButton lnkbtnEdit = (LinkButton)e.Row.FindControl("lnkbtnEdit");
                lnkbtnDel.CommandArgument = e.Row.RowIndex.ToString();
                lnkbtnEdit.CommandArgument = e.Row.RowIndex.ToString();
            }
        }

        public string getRole(string userRole)
        {
            string RoleName = "";
            if (userRole == "0")
            {
                RoleName = "管理员";
            }
            else if (userRole == "1")
            {
                RoleName = "会员";
            }
            else if (userRole == "2")
            {
                RoleName = "版主";
            }
            return RoleName;
        }

        protected void gvInfo_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            int index = int.Parse(e.CommandArgument.ToString());
            if (e.CommandName == "Del")
            {
                int userId = Convert.ToInt32(gvInfo.DataKeys[index].Value.ToString());
                if (userBll.DelUser(userId))
                {
                    Response.Redirect("UserList.aspx");
                }
            }
            else
                if (e.CommandName == "Edit")
            {
                int userId = Convert.ToInt32(gvInfo.DataKeys[index].Value.ToString());
                Response.Redirect("user_Edit.aspx?userId=" + userId);
            }
        }

        //查找按钮
        protected void btnFind_Click(object sender, EventArgs e)
        {
            string userName = txtName.Text.Trim();
            string userSex = "";
            if (rdbtnBoy.Checked)
                userSex = "男";
            if (rdbtnGirl.Checked)
                userSex = "女";
            if (RadioButton1.Checked == true)
                userSex = "";
            string userRole = ddlRole.SelectedItem.Value.ToString();
            DataSet ds = userBll.GetUsers(userName, userSex, userRole);
            if (ds != null)
            {
                lbShow.Text = "共找到" + ds.Tables[0].Rows.Count + "条记录";
                gvInfo.DataSource = ds;
                gvInfo.DataBind();
            }
            else
            {
                lbShow.Text = "没有符合条件的记录";
                this.GridViewBd();
            }
        }

        protected void gvInfo_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvInfo.PageIndex = e.NewPageIndex;
            this.GridViewBd();
        }
    }
}