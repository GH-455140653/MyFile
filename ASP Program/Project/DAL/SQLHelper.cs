using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;
namespace DAL
{
    public class SQLHelper
    {
        public static SqlConnection con;  //定义数据库连接对象

        /// <summary>
        /// 连接数据库
        /// </summary>
        #region Connection属性
        public static SqlConnection Connection
        {
            get
            {
                string connectionString =  ConfigurationManager.ConnectionStrings["pubs"].ToString();
                if (con == null)
                {
                    con = new SqlConnection(connectionString);
                    con.Open();
                }
                else if (con.State == System.Data.ConnectionState.Broken)
                {
                    con.Close();
                    con.Open();
                }
                else if (con.State == System.Data.ConnectionState.Closed)
                {
                    con.Open();
                }
                return con;
            }
        }
        #endregion

        #region 根据查询条件填充数据 带参数
        /// <summary>
        /// 根据查询条件填充数据
        /// </summary>
        /// <param name="sqlStr">SQL语句</param>
        /// <param name="param">SQL参数</param>
        /// <returns>数据集对象</returns>
        public DataSet GetDataSet(string sqlStr, SqlParameter[] param)
        {
            SqlCommand cmd = new SqlCommand(sqlStr, Connection);
            cmd.Parameters.AddRange(param);
            DataSet ds = new DataSet();
            SqlDataAdapter dapt = new SqlDataAdapter(cmd);
            dapt.Fill(ds);
            return ds;
        }
        #endregion

        #region 根据查询条件填充数据 不带参数
        /// <summary>
        /// 根据查询条件填充数据
        /// </summary>
        /// <param name="sqlStr">Sql语句</param>
        /// <returns>数据集对象</returns>
        public DataSet GetDataSet(string sqlStr)
        {
            SqlCommand cmd = new SqlCommand(sqlStr, Connection);
            DataSet ds = new DataSet();
            SqlDataAdapter dapt = new SqlDataAdapter(cmd);
            dapt.Fill(ds);
            return ds;
        }
        #endregion

        #region 执行Execute命令
        /// <summary>
        /// 执行更新操作（增加、删除、修改）
        /// </summary>
        /// <param name="sqlStr">SQL语句</param>
        /// <returns>bool型数据</returns>
        public bool ExecuteCommand(string sqlStr)
        {
            SqlCommand cmd = new SqlCommand(sqlStr, Connection);
            cmd.ExecuteNonQuery();
            return true;
        }

        /// <summary>
        /// 执行更新操作（增加、删除、修改）
        /// </summary>
        /// <param name="sqlStr">SQL语句</param>
        /// <param name="param">SQL参数</param>
        /// <returns>bool型数据</returns>
        public bool ExecuteCommand(string sqlStr, SqlParameter[] param)
        {
            SqlCommand cmd = new SqlCommand(sqlStr, Connection);
            cmd.Parameters.AddRange(param);
            cmd.ExecuteNonQuery();
            return true;
        }
        #endregion
    }
}
