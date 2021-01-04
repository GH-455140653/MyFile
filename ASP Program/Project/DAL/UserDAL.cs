using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using Model;
namespace DAL
{
    public class UserDAL
    {
        #region 添加用户
        /// <summary>
        /// 添加用户
        /// </summary>
        /// <param name="user">用户Model</param>
        /// <returns>bool型数据</returns>
        public bool CreateUser(User user)
        {
            string strSql = "insert into tbUser(userName,userPswd,userSex,userAge,userEmail,userAddress,userRole,userPhoto) values(@userName,@userPassword,@userSex,@userAge,@userEmail,@userAddress,@userRole,@UserPhoto)";
            SqlParameter[] param ={
                                     new SqlParameter("@userName",user.UserName),
                                     new SqlParameter("@userPassword",user.UserPswd),
                                     new SqlParameter("@userSex",user.UserSex),
                                     new SqlParameter("@userAge",user.UserAge),
                                     new SqlParameter("@userEmail",user.UserEmail),
                                     new SqlParameter("@userAddress",user.UserAddress),
                                     new SqlParameter("@userRole",user.UserRole),
                                     new SqlParameter("@UserPhoto",user.UserPhoto),
                                 };
            SQLHelper help = new SQLHelper();
            if (help.ExecuteCommand(strSql, param))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        #endregion

        #region 删除用户（按照userID）
        /// <summary>
        /// 删除用户
        /// </summary>
        /// <param name="userID">用户ID</param>
        /// <returns></returns>
        public bool DelUser(int userID)
        {
            string strSql = "delete from tbUser where userID=@userid";
            SqlParameter[] param ={
                                 new SqlParameter("@userid",userID)
                                 };
            SQLHelper help = new SQLHelper();
            if (help.ExecuteCommand(strSql, param))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        #endregion

        #region 修改用户信息
        /// <summary>
        /// 修改用户信息
        /// </summary>
        /// <param name="user"></param>
        /// <returns></returns>
        public bool UpdateUser(User user)
        {
            string strSql = "update tbUser set userPswd=@userPassword,userSex=@userSex,userAge=@userAge,userEmail=@userEmail,userAddress=@userAddress,userRole=@userRole,userPhoto=@userPhoto where userID=@userId";
            SqlParameter[] param = {
                                   new SqlParameter("@userId",user.UserID),
                                   new SqlParameter("@userPassword",user.UserPswd),
                                   new SqlParameter("@userSex",user.UserSex),
                                   new SqlParameter("@userAge",user.UserAge),
                                   new SqlParameter("@userEmail",user.UserEmail),
                                   new SqlParameter("@userAddress",user.UserAddress),
                                   new SqlParameter("@userRole",user.UserRole),
                                   new SqlParameter("@userPhoto",user.UserPhoto)
                                   };
            SQLHelper help = new SQLHelper();
            if (help.ExecuteCommand(strSql, param))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        #endregion

        #region 查询用户
        /// <summary>
        /// 查询用户 不带参数
        /// </summary>
        /// <returns></returns>
        public DataSet GetUsers()
        {
            string sqlStr = "select * from tbUser";
            SQLHelper help = new SQLHelper();
            DataSet ds = help.GetDataSet(sqlStr);
            if (ds != null && ds.Tables[0].Rows.Count > 0)
            {
                return ds;
            }
            else
            {
                return null;
            }
        }

        /// <summary>
        /// Login方法，带两个参数，用户名和密码
        /// </summary>
        /// <param name="userName"></param>
        /// <param name="userPassword"></param>
        /// <returns></returns>
        public DataSet Login(string userName, string userPassword)
        {
            string sqlStr = "select * from tbUser where userName=@userName and userPswd=@userPswd";
            SqlParameter[] param = {
                                   new SqlParameter("@userName",userName),
                                   new SqlParameter("@userPswd",userPassword)
                                   };
            SQLHelper help = new SQLHelper();
            DataSet ds = help.GetDataSet(sqlStr, param);
            if (ds != null && ds.Tables[0].Rows.Count > 0)
            {
                return ds;
            }
            else
            {
                return null;
            }
        }

        /// <summary>
        /// 根据用户名、性别、角色查询数据
        /// </summary>
        /// <param name="userName"></param>
        /// <param name="userSex"></param>
        /// <param name="userRole"></param>
        /// <returns></returns>
        public DataSet GetUsers(string userName, string userSex, string userRole)
        {
            string sqlStr = "select * from tbUser where 1=1";
            if (userName != "")
            {
                sqlStr += " and userName like '%" + userName + "%'";
            }
            if (userSex != "")
            {
                sqlStr += " and userSex='" + userSex + "'";
            }
            if (userRole == "1" || userRole == "2" || userRole == "0")
            {
                sqlStr += " and userRole='" + userRole + "'";
            }
            SQLHelper help = new SQLHelper();
            DataSet ds = help.GetDataSet(sqlStr);
            if (ds != null && ds.Tables[0].Rows.Count > 0)
            {
                return ds;
            }
            else
            {
                return null;
            }
        }

        public User GetUserByuserId(int userId)
        {
            string sqlStr = "select * from tbUser where userID=" + userId + "";
            SQLHelper help = new SQLHelper();
            DataSet ds = help.GetDataSet(sqlStr);
            User user = new User();
            if (ds != null && ds.Tables[0].Rows.Count > 0)
            {
                user.UserName = ds.Tables[0].Rows[0]["userName"].ToString();
                user.UserID = userId;
                user.UserEmail = ds.Tables[0].Rows[0]["userEmail"].ToString();
                user.UserAddress = ds.Tables[0].Rows[0]["userAddress"].ToString();

                user.UserAge = Convert.ToInt32(ds.Tables[0].Rows[0]["userAge"].ToString().Trim());
                user.UserPswd = ds.Tables[0].Rows[0]["userPswd"].ToString();
                user.UserSex = ds.Tables[0].Rows[0]["userSex"].ToString();
                user.UserRole = ds.Tables[0].Rows[0]["userRole"].ToString();
                user.UserPhoto = ds.Tables[0].Rows[0]["userPhoto"].ToString();
            }
            return user;
        }
        #endregion
    }
}
