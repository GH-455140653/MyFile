using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Revert
    {
        private int revertID;  //回帖编号
        public int RevertID
        {
            get { return revertID; }
            set { revertID = value; }
        }
        private string revertTitle;  //回帖标题
        public string RevertTitle
        {
            get { return revertTitle; }
            set { revertTitle = value; }
        }
        private string revertContent;  //回帖内容
        public string RevertContent
        {
            get { return revertContent; }
            set { revertContent = value; }
        }
        private int userID;  //用户ID
        public int UserID
        {
            get { return userID; }
            set { userID = value; }
        }
        private DateTime revertDate;  //回帖日期
        public DateTime RevertDate
        {
            get { return revertDate; }
            set { revertDate = value; }
        }
        private int postID;  //帖子编号
        public int PostID
        {
            get { return postID; }
            set { postID = value; }
        }
    }
}
