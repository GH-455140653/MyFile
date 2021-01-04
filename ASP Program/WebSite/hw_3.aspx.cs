using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;

namespace WebSite
{
    public partial class hw_3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void GridView1_SelectedIndexChanging(object sender, GridViewSelectEventArgs e)
        {
            string strID = GridView1.DataKeys[e.NewSelectedIndex].Value.ToString();
            string sqlStr = "select ID,StuName as 学生姓名,Phone as 电话,Address as 住址,City as 城市,State as 国家 from Students where ID=" + strID + "";
            SqlConnection myconn = new SqlConnection();
            myconn.ConnectionString = ConfigurationManager.ConnectionStrings["pubs"].ToString();
            myconn.Open();
            SqlDataAdapter myadapter = new SqlDataAdapter(sqlStr, myconn);
            DataSet ds = new DataSet();
            myadapter.Fill(ds, "tt");
            myconn.Close();
            GridView2.DataSource = ds.Tables["tt"];
            GridView2.DataBind();

        }
    }
}