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
    public class PostDAL
    {
        #region 发表一个新帖
        public bool CreatePost(Post post)
        {
            string sqlStr = "insert into tbPost(postTitle,postContent,postDate,userId,ModuleId) values(@postTitle,@postContent,@postDate,@userId,@ModuleId)";
            SqlParameter[] param ={
                                    new SqlParameter("@postTitle",post.PostTitle ),
                                    new SqlParameter ("@postContent",post.PostContent ),
                                    new SqlParameter ("@postDate",post .PostDate ),
                                    new SqlParameter ("@userId",post.UserID ),
                                    new SqlParameter ("@ModuleId",post.ModuleID )
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

        #region 编辑帖子
        public bool UpdatePost(Post post)
        {
            string sqlStr = "update tbPost set postTitle=@postTitle,postContent=@postContent where postId=@postId";
            SqlParameter[] param ={
                                    new SqlParameter ("@postTitle",post.PostTitle ),
                                    new SqlParameter ("@postContent",post.PostContent ),
                                    new SqlParameter ("@postId",post .PostID )
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

        #region  删除帖子
        public bool DelPost(int postId)
        {
            string sqlStr = "Delete from tbPost where postId=@postId";
            SqlParameter[] param ={
                                    new SqlParameter ("@postId",postId )
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

        #region  查询帖子信息，包含带参数和不带参数的
        public DataSet GetPostByModuleId(int moduleId)
        {
            //string sqlStr = "select * from tbPost where moduleId=@moduleId";
            //SqlParameter[] param ={ 
            //                          new SqlParameter ("@ModuleId",moduleId)
            //};
            string sqlStr = "select b.postId,a.ModuleName,b.postTitle, b.postContent,c.UserName,b.postDate"
               + " from tbModule a, tbPost b,tbUser c  "
               + "where  a.ModuleId=b.ModuleId  and b.UserId=c.UserId "
               + "and  a.ModuleId=@ModuleId";
            SqlParameter[] param ={
                                               new SqlParameter ("@ModuleId",moduleId)
          };
            SQLHelper help = new SQLHelper();
            DataSet ds = help.GetDataSet(sqlStr, param);
            try
            {
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

        public Post GetPostByPostId(int postId)
        {
            string sqlStr = "select * from tbPost where postId=@postId";
            SqlParameter[] param ={
                                    new SqlParameter ("@postId",postId)
          };
            SQLHelper help = new SQLHelper();
            DataSet ds = help.GetDataSet(sqlStr, param);
            try
            {
                if (ds.Tables[0].Rows.Count > 0)
                {
                    Post post = new Post();
                    post.PostTitle = ds.Tables[0].Rows[0]["postTitle"].ToString();
                    post.PostID = postId;
                    post.PostContent = ds.Tables[0].Rows[0]["postContent"].ToString();
                    post.UserID = Convert.ToInt32(ds.Tables[0].Rows[0]["userId"].ToString());
                    post.ModuleID = Convert.ToInt32(ds.Tables[0].Rows[0]["ModuleId"].ToString());
                    post.PostDate = Convert.ToDateTime(ds.Tables[0].Rows[0]["postDate"].ToString());

                    return post;
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

        public DataSet GetPosts(string ModuleName, string UserName, string postTitle)
        {
            string sqlStr = "select p.postTitle,u.UserName,p.buildDate from tbPost p,tbUser u,tbModule m where p.UserId=u.UserId and p.ModuleId=m.ModuleId and 1=1";
            if (ModuleName != "")
            {
                sqlStr += " and ModuleName=@ModuleName";
            }
            if (UserName != "")
            {
                sqlStr += " and UserName like %@userName";
            }
            if (postTitle != "")
            {
                sqlStr += " and postTitle like %@postTitle";
            }
            SqlParameter[] param ={
                                    new SqlParameter ("@ModuleName",ModuleName),
                                    new SqlParameter ("@userName",UserName),
                                    new SqlParameter ("@postTitle",postTitle)
          };
            SQLHelper help = new SQLHelper();
            DataSet ds = help.GetDataSet(sqlStr, param);
            try
            {
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
