using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
   public class Post
    {
        private int postID;  //帖子编号
        public int PostID
        {
            get { return postID; }
            set { postID = value; }
        }
        private string postTitle;  //帖子标题
        public string PostTitle
        {
            get { return postTitle; }
            set { postTitle = value; }
        }
        private string postContent;  //帖子内容
        public string PostContent
        {
            get { return postContent; }
            set { postContent = value; }
        }
        private int userID;  //用户ID
        public int UserID
        {
            get { return userID; }
            set { userID = value; }
        }
        private DateTime postDate;  //发帖时间
        public DateTime PostDate
        {
            get { return postDate; }
            set { postDate = value; }
        }
        private int moduleID;  //发帖版块
        public int ModuleID
        {
            get { return moduleID; }
            set { moduleID = value; }
        }   
    }
}
