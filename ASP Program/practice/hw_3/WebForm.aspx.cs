using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Configuration;
using System.Data;


namespace hw_3
{
    public partial class WebForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                bingData();
            }
        }

        protected void bingData()
        {
            SqlConnection con = new SqlConnection();
            con.ConnectionString = ConfigurationManager.ConnectionStrings["pubs"].ToString();
            string sql = "select ID,StuName as 学生姓名,Phone as 电话,Address as 住址,City as 城市,State as 国家 from Students ";
            SqlDataAdapter myadapter = new SqlDataAdapter(sql, con);
            DataSet ds = new DataSet();
            myadapter.Fill(ds, "tt");
            GridView1.DataSource = ds.Tables["tt"];
            GridView1.DataKeyNames = new string[] { "ID" };
            GridView1.DataBind();
        }

        protected void GridView1_RowEditing(object sender, GridViewEditEventArgs e)
        {
            GridView1.EditIndex = e.NewEditIndex;
            bingData();
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void GridView1_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            SqlConnection con = new SqlConnection();
            con.ConnectionString = ConfigurationManager.ConnectionStrings["pubs"].ToString();
            con.Open();
            string name = ((TextBox)((GridView1.Rows[e.RowIndex].Cells[2].Controls[0]))).Text.ToString().Trim();
            string phone = ((TextBox)((GridView1.Rows[e.RowIndex].Cells[2].Controls[0]))).Text.ToString().Trim();
            string address = ((TextBox)((GridView1.Rows[e.RowIndex].Cells[2].Controls[0]))).Text.ToString().Trim();
            string city = ((TextBox)((GridView1.Rows[e.RowIndex].Cells[2].Controls[0]))).Text.ToString().Trim();
            string state = ((TextBox)((GridView1.Rows[e.RowIndex].Cells[2].Controls[0]))).Text.ToString().Trim();
            string id = GridView1.DataKeys[e.RowIndex].Value.ToString();
            string sqlStr = "update Students set StuName='" + name + "',Phone='" + phone + "',Address='" + address + "',City='" + city + "',State='" + state + "' where ID=" + id + "";
            SqlCommand cmd = new SqlCommand(sqlStr, con);
            cmd.ExecuteNonQuery();
            con.Close();
            GridView1.EditIndex = -1;
            bingData();
        }

        protected void GridView1_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
        {
            GridView1.EditIndex = -1;
            bingData();
        }

        protected void GridView1_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            SqlConnection con = new SqlConnection();
            con.ConnectionString = ConfigurationManager.ConnectionStrings["pubs"].ToString();
            con.Open();
            string sql = "delete from Students where ID=" + GridView1.DataKeys[e.RowIndex].Value.ToString();
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.ExecuteNonQuery();
            con.Close();
            GridView1.EditIndex = -1;
            bingData();
        }

        protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                if (e.Row.RowState == DataControlRowState.Normal || e.Row.RowState == DataControlRowState.Alternate)
                {
                    ((LinkButton)(e.Row.Cells[1].Controls[0])).Attributes.Add("onclick", "return confirm('真的要删除吗？')");
                }
            }

        }

        protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            GridView1.PageIndex = e.NewPageIndex;
            bingData();
        }
    }
}