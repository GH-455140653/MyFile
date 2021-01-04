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
    public class ModuleDAL
    {
        #region 添加新的版块
        public bool CreateModule(Module module)
        {
            string sqlStr = "insert into tbModule(ModuleName,ModuleIntro,BuildDate) values(@ModuleName,@ModuleIntro,@BuildDate)";
            SqlParameter[] param ={
                                    new SqlParameter ("@ModuleName",module.ModuleName ),
                                    new SqlParameter ("@ModuleIntro",module.ModuleIntro ),
                                    new SqlParameter ("@BuildDate",module.BuildDate )
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

        #region 修改版块信息
        public bool UpdateModule(Module module)
        {
            string sqlStr = "Update tbModule set ModuleName=@ModuleName,ModuleIntro=@ModuleIntro where moduleId=@moduleId";
            SqlParameter[] param ={
                                    new SqlParameter ("@ModuleName",module.ModuleName ),
                                    new SqlParameter ("@ModuleIntro",module.ModuleIntro ),
                                    new SqlParameter ("@moduleId",module.ModuleID )
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

        #region 删除版块信息
        public bool DelModule(int ModuleId)
        {
            string sqlStr = "Delete from tbModule where ModuleId=@ModuleId";
            SqlParameter[] param ={
                                    new SqlParameter ("@ModuleId",ModuleId)
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

        #region 查询版块信息,包含带参数和不带参数的
        public DataSet GetModule()
        {
            string sqlStr = "select * from tbModule";
            try
            {
                SQLHelper help = new SQLHelper();
                DataSet ds = help.GetDataSet(sqlStr);
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

        public Module GetModuleById(int ModuleId)
        {
            string sqlStr = "select * from tbModule where ModuleId=@ModuleId";
            SqlParameter[] param ={
                                    new SqlParameter ("@ModuleId",ModuleId )
          };
            try
            {
                SQLHelper help = new SQLHelper();
                DataSet ds = help.GetDataSet(sqlStr, param);
                Module module = new Module();
                if (ds.Tables[0].Rows.Count > 0)
                {
                    module.ModuleID = ModuleId;
                    module.ModuleName = ds.Tables[0].Rows[0]["moduleName"].ToString();
                    module.ModuleIntro = ds.Tables[0].Rows[0]["moduleIntro"].ToString();
                    module.BuildDate = Convert.ToDateTime(ds.Tables[0].Rows[0]["BuildDate"].ToString());
                    return module;
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
        public DataSet GetModuleByName(string moduleName)
        {
            string sqlStr = "select * from tbModule where ModuleName like '%'+ @ModuleName +'%'";
            SqlParameter[] param ={
                                    new SqlParameter ("@ModuleName",moduleName)
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
