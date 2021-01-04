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
    public class UserBLL
    {
        UserDAL userDal = new UserDAL();
        public bool CreateUser(User user)
        {
            return userDal.CreateUser(user);
        }
        public bool DelUser(int userId)
        {
            return userDal.DelUser(userId);
        }
        public bool UpdateUser(User user)
        {
            return userDal.UpdateUser(user);
        }
        public DataSet GetUsers()
        {
            return userDal.GetUsers();
        }
        public DataSet GetUser(string userName, string userPassword)
        {
            return userDal.Login(userName, userPassword);
        }
        public User GetUserByuserId(int userId)
        {
            return userDal.GetUserByuserId(userId);
        }
        public DataSet GetUsers(string userName, string userSex, string userRole)
        {
            return userDal.GetUsers(userName, userSex, userRole);
        }
    }
}
