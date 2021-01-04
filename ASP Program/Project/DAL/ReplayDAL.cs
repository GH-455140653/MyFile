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
    public class ReplayDAL
    {
        #region 对帖子发表回复
        public bool CreateReplay(Revert replay)
        {
            string sqlStr = "insert into tbRevert(revertTitle,revertContent,revertDate,postID,userID) values(@RevertTitle,@RevertContent,@RevertDate,@postId,@userId)";
            SqlParameter[] param ={
                                    new SqlParameter("@RevertTitle",replay.RevertTitle ),
                                    new SqlParameter ("@RevertContent",replay .RevertContent ),
                                    new SqlParameter ("@RevertDate",replay.RevertDate ),
                                    new SqlParameter ("@postId",replay.PostID ),
                                    new SqlParameter ("@userId",replay.UserID )
          };

            try
            {
                SQLHelper help = new SQLHelper();
                if (help.ExecuteCommand(sqlStr, param))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch
            {
                return false;
            }
        }
        #endregion

        #region 对回复信息进行编辑
        public bool UpdateReplay(Revert replay)
        {
            string sqlStr = "Update tbRevert set RevertTitle=@RevetTitle, RevertContent=@RevertContent where RervertId=@RevertId";
            SqlParameter[] param ={
                                    new SqlParameter("@RevertTitle",replay.RevertTitle ),
                                    new SqlParameter ("@RevertContent",replay .RevertContent ),
                                    new SqlParameter ("@RevertId",replay.RevertID)
            };
            try
            {
                SQLHelper help = new SQLHelper();
                if (help.ExecuteCommand(sqlStr, param))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch
            {
                return false;
            }
        }
        #endregion

        #region 删除回复信息
        public bool DelReplay(int RevertId)
        {
            string sqlStr = "Delete from tbRevert where RevertId=@RevertId";
            SqlParameter[] param ={
                                    new SqlParameter ("@RevertId",RevertId)
          };
            try
            {
                SQLHelper help = new SQLHelper();
                if (help.ExecuteCommand(sqlStr, param))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch
            {
                return false;
            }
        }
        #endregion

        #region 查询回复帖子信息
        public DataSet getRevertByPostId(int postId)
        {
            string sqlStr = "select * from tbRevert where postId=@postId order by RevertDate";
            SqlParameter[] param ={
                                        new SqlParameter ("@postId",postId)
            };
            try
            {
                SQLHelper help = new SQLHelper();
                DataSet ds = help.GetDataSet(sqlStr, param);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    return ds;
                }
                else
                {
                    return null;
                }
            }
            catch
            {
                return null;
            }
        }
        #endregion
    }
}
