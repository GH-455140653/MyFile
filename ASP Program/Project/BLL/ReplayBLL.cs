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
    public class ReplayBLL
    {
        ReplayDAL replayDal = new ReplayDAL();

        public bool CreateReplay(Revert replay)
        {
            return replayDal.CreateReplay(replay);
        }
        public bool UpdateReplay(Revert replay)
        {
            return replayDal.UpdateReplay(replay);
        }
        public bool DelReplay(int RevertId)
        {
            return replayDal.DelReplay(RevertId);
        }
        public DataSet getRevertByPostId(int postId)
        {
            return replayDal.getRevertByPostId(postId);
        }
    }
}
