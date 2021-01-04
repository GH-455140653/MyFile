using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DAL;
using Model;
using System.Data;
namespace BLL
{
    public class PostBLL
    {
        PostDAL postdal = new PostDAL();
        public bool CreatePost(Post post)//发表帖子
        {
            return postdal.CreatePost(post);
        }

        public bool UpdatePost(Post post)//修改帖子内容
        {
            return postdal.UpdatePost(post);
        }
        public bool DelPost(int postId)//删除帖子
        {
            return postdal.DelPost(postId);
        }
        public DataSet GetPostByModuleId(int moduleId)//获取帖子信息
        {
            return postdal.GetPostByModuleId(moduleId);
        }
        public Post GetPostByPostId(int postId)//根据帖子ID获取帖子信息
        {
            return postdal.GetPostByPostId(postId);

        }
        public DataSet GetPosts(string ModuleName, string UserName, string postTitle)//根据条件查询帖子信息
        {
            return postdal.GetPosts(ModuleName, UserName, postTitle);
        }
    }
}
