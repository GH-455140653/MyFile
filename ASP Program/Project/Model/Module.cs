using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Module
    {
        private int moduleID; //版块ID
        public int ModuleID
        {
            get { return moduleID; }
            set { moduleID = value; }
        }
        private string moduleName; //版块名称
        public string ModuleName
        {
            get { return moduleName; }
            set { moduleName = value; }
        }
        private string moduleIntro; //版块说明
        public string ModuleIntro
        {
            get { return moduleIntro; }
            set { moduleIntro = value; }
        }
        private DateTime buildDate; //版块创建时间
        public DateTime BuildDate
        {
            get { return buildDate; }
            set { buildDate = value; }
        }
    }
}
