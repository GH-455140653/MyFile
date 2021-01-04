using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BLL;
using Model;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;

namespace WebUI
{
    public partial class WebForm : System.Web.UI.Page
    {
        ModuleBLL moduleBll = new ModuleBLL();
        protected void Page_Load(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection();
            con.ConnectionString = ConfigurationManager.ConnectionStrings["pubs"].ToString();
            con.Open();
            string mysql = "select * from tbmodule";
            SqlDataAdapter ad = new SqlDataAdapter(mysql, con);
            DataSet ds = new DataSet();
            ad.Fill(ds, "tt");
            GridView1.DataSource = ds.Tables["tt"];
            GridView1.DataBind();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Label1.Text = FreeTextBox1.Text;
        }
    }
}