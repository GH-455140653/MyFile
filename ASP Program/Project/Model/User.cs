using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
   public class User
    {
        private int userID;  //用户ID
        public int UserID
        {
            get { return userID; }
            set { userID = value; }
        }
        private string userName;   //用户姓名
        public string UserName
        {
            get { return userName; }
            set { userName = value; }
        }
        private string userPswd;  //用户密码
        public string UserPswd
        {
            get { return userPswd; }
            set { userPswd = value; }
        }
        private string userSex;  //用户性别
        public string UserSex
        {
            get { return userSex; }
            set { userSex = value; }
        }
        private int userAge;  //用户年龄
        public int UserAge
        {
            get { return userAge; }
            set { userAge = value; }
        }
        private string userEmail;  //Email地址
        public string UserEmail
        {
            get { return userEmail; }
            set { userEmail = value; }
        }
        private string userAddress;  //用户地址
        public string UserAddress
        {
            get { return userAddress; }
            set { userAddress = value; }
        }
        private string userRole; //用户角色
        public string UserRole
        {
            get { return userRole; }
            set { userRole = value; }
        }
        private string userPhoto;  //头像
        public string UserPhoto
        {
            get { return userPhoto; }
            set { userPhoto = value; }
        }
    }
}
