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
    public class ModuleBLL
    {
        ModuleDAL moduleDal = new ModuleDAL();
        public bool CreateModule(Module module)
        {
            return moduleDal.CreateModule(module);
        }
        public bool UpdateModule(Module module)
        {
            return moduleDal.UpdateModule(module);
        }
        public bool DelModule(int ModuleId)
        {
            return moduleDal.DelModule(ModuleId);
        }
        public DataSet GetModule()
        {
            return moduleDal.GetModule();
        }
        public Module GetModuleById(int ModuleId)
        {
            return moduleDal.GetModuleById(ModuleId);
        }
        public DataSet GetModuleByName(string moduleName)
        {
            return moduleDal.GetModuleByName(moduleName);
        }
    }
}
