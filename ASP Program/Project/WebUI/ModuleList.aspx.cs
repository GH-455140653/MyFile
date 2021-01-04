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
    public partial class ModuleList : System.Web.UI.Page
    {
        ModuleBLL moduleBll = new ModuleBLL();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                this.GridViewBd();
                // Master.Description.Text = "版块管理";
                (Master.FindControl("lbDescription") as Label).Text = "版块管理";
            }
        }

        void GridViewBd()
        {
            gvInfo.DataSource = moduleBll.GetModule().Tables[0].DefaultView;
            gvInfo.DataBind();
        }

        //查找按钮
        protected void btnFind_Click(object sender, EventArgs e)
        {
            string moduleName = txtName.Text.Trim();
            DataSet ds = moduleBll.GetModuleByName(moduleName);
            if (ds != null)
            {
                gvInfo.DataSource = ds.Tables[0].DefaultView;
                gvInfo.DataBind();
            }
            else
            {
                lbShow.Text = "没有找到符合条件的记录！";
                this.GridViewBd();
            }
        }
        //添加按钮
        protected void btnSearch_Click(object sender, EventArgs e)
        {
            Response.Redirect("Module_Add.aspx");
        }

        //全选复选框
        protected void CheckBox2_CheckedChanged(object sender, EventArgs e)
        {
            for (int i = 0; i < gvInfo.Rows.Count; i++)
            {
                CheckBox cb = (CheckBox)gvInfo.Rows[i].FindControl("checkBox1");
                if (CheckBox2.Checked)
                    cb.Checked = true;
                else
                    cb.Checked = false;
            }
        }
        protected void gvInfo_RowCreated(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                //实例化两个LinkButton
                LinkButton lnkbtnDel = (LinkButton)e.Row.FindControl("lnkbtnDel");
                LinkButton lnkbtnEdit = (LinkButton)e.Row.FindControl("lnkbtnEdit");

                lnkbtnDel.CommandArgument = e.Row.RowIndex.ToString();
                lnkbtnEdit.CommandArgument = e.Row.RowIndex.ToString();

                lnkbtnDel.Attributes.Add("onclick", "return confirm('确定删除吗？');");
            }
        }
        protected void gvInfo_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            int index = int.Parse(e.CommandArgument.ToString());
            if (e.CommandName == "Edit")
            {
                int moduleId = int.Parse(gvInfo.DataKeys[index].Value.ToString());
                Response.Redirect("Module_Edit.aspx?moduleId=" + moduleId);
            }
            else if (e.CommandName == "Del")
            {
                int moduleId = int.Parse(gvInfo.DataKeys[index].Value.ToString());
                if (moduleBll.DelModule(moduleId))
                {
                    //Response.Write("javascript:alert('删除成功！')");            
                    //Response.Redirect("moduleList.aspx");
                    Response.Write("<script>alert('修改成功！');location.href='moduleList.aspx';</script>");
                }
                else
                {
                    string errorMsg = "请删除该板块的帖子信息！";
                    Session["errorMsg"] = errorMsg;
                    Response.Redirect("errorPage.aspx");
                }
            }
        }
        //删除按钮
        protected void btnDelete_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < gvInfo.Rows.Count; i++)
            {
                CheckBox cb = (CheckBox)gvInfo.Rows[i].FindControl("checkBox1");
                if (cb.Checked)
                {
                    DataKey dk = gvInfo.DataKeys[i];
                    int moduleId = Convert.ToInt32(dk["ModuleId"].ToString());
                    moduleBll.DelModule(moduleId);
                }
            }
            this.GridViewBd();
        }

        protected void gvInfo_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvInfo.PageIndex = e.NewPageIndex;
            this.GridViewBd();
        }
    }
}