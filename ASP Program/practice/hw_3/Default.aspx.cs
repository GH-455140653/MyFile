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
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void GridView1_SelectedIndexChanging(object sender, GridViewSelectEventArgs e)
        {
            string EId = GridView1.DataKeys[e.NewSelectedIndex].Value.ToString();
            string mysql= "select ID,StuName as 学生姓名,Phone as 电话,Address as 住址,City as 城市,State as 国家 from Students where ID=" + EId + "";
            SqlConnection con = new SqlConnection();
            con.ConnectionString = ConfigurationManager.ConnectionStrings["pubs"].ToString();
            con.Open();
            SqlDataAdapter adapter = new SqlDataAdapter(mysql,con);
            DataSet ds = new DataSet();
            adapter.Fill(ds, "tt");
            con.Close();
            GridView2.DataSource = ds.Tables["tt"];
            GridView2.DataBind();
        }
    }
}