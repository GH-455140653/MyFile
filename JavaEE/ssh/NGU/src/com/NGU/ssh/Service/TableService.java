package com.NGU.ssh.Service;

import com.NGU.ssh.DAO.TableDao;
import com.NGU.ssh.Model.Classify;
import com.NGU.ssh.Model.Member_logindate;
import com.NGU.ssh.Model.Video;
import com.opensymphony.xwork2.ActionContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Component
public class TableService {
    private TableDao tableDao;

    public TableDao getTableDao() {
        return tableDao;
    }

    @Resource
    public void setTableDao(TableDao tableDao) {
        this.tableDao = tableDao;
    }

    @Transactional(readOnly = true)
    public Boolean getUser() {//获取全部年份用户登录数
        List<Member_logindate> member_logindates = tableDao.getMember_logindateMsg();//获取普通用户表的全部数据
        ArrayList ulist = new ArrayList();//用来存放每年的登录数
//        for(int i=0;i<member_logindates.size();i++){
//        	ulist.add(0);
//        }
        for (Member_logindate member_logindate : member_logindates) {

            ulist.add(member_logindate.getLogin_date());//member_logindate.getLogin_date()

        }
        ActionContext.getContext().getSession().put("userListR", ulist);
//        ActionContext.getContext().getSession().put("zsb", 1000);
        return true;
    }


    @Transactional
    public Boolean getVideo() {//获取全部年份视频上传数
        List<Video> videos = tableDao.getVideoMsg();//获取视频表的全部数据
        List<Classify> classifies = tableDao.getClassifyMsg();//获取分类表的全部数据
        ArrayList vlist = new ArrayList();//用来存放每年的视频上传数
        ArrayList clist = new ArrayList();//用来存放每年的视频上传数
//        for(int i=0;i<videos.size();i++){
//        	year.add(0);
//        }
        for (Video video : videos) {
            vlist.add(video.getC_id());
            vlist.add(video.getVideo_date());
        }
        for (Classify classify : classifies) {
            clist.add(classify.getC_id());
            clist.add(classify.getC_name());
        }
        ActionContext.getContext().getSession().put("videoListR", vlist);
        ActionContext.getContext().getSession().put("classListR", clist);
        return true;
    }


//    @Transactional(readOnly = true)
//    public Map getVideo_EveryDay(int year,int month,int day) {//获取某一天上传的全部视频的分类和数量
//    	 Map everyday=new HashMap();//用来某一天上传的全部视频的分类和数量
////         for(int i=0;i<31;i++){
////        	 everyday.put(key, value);
////         }
//         for (Video video : videos) {
//        	 if(video.getVideo_date().getYear()==year&&video.getVideo_date().getMonth()==month&&video.getVideo_date().getDay()==day){
//        		 everyday.put(video.getC2_id(),  Integer.parseInt(day.get(video.getVideo_date().getDay() ).toString())+1);
//        	 }
//         }
//         return everyday;
//    }

}
