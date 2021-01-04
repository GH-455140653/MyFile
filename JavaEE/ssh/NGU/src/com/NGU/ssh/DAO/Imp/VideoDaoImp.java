/*
 * @ProjectName:  [NGU]
 * @Package:      [com.NGU.ssh.DAO.Imp]
 * @ClassName:    [VideoDaoImp]
 * @Description:  [视频模块的数据库底层封装类]
 * @Author:       [lrl]
 * @CreateDate:   [2020/11/25 15:39]
 *
 */
package com.NGU.ssh.DAO.Imp;

import com.NGU.ssh.DAO.VideoDao;
import com.NGU.ssh.Model.Classify;
import com.NGU.ssh.Model.Member;
import com.NGU.ssh.Model.Record;
import com.NGU.ssh.Model.Video;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class VideoDaoImp implements VideoDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 数据库的视频存储
     * @param video 存入视频相关字段
     * @return boolean
     */
    @Override
    public boolean saveVideo(Video video) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(video);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 查询视频表内的所有信息
     * @return List
     */
    @Override
    public List<Video> getVideosMsg() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from video");
        return (List<Video>) query.list();
    }

    /**
     * 多表查询，返回一个数组集合
     * @return List
     */
    @Override
    public List<Video> getCVMsg() {
        Session session = sessionFactory.getCurrentSession();
/*        Query query = session.createSQLQuery
                ("select {v.*},{c.*} from video v,classify c where v.c_id=c.c_id").addEntity("v",Video.class).addEntity("c",Classify.class);*/
        String hql="select new video(video_title,video_name) from video v";
        Query query=session.createQuery(hql);
        return query.list();
    }

    /**
     * 存入记录信息
     * @param record 提供所有记录信息
     * @return boolean
     */
    @Override
    public boolean saveVideoPlayMsg(Record record) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(record);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 删除指定视频
     * @param video 提供视频id
     * @return boolean
     */
    @Override
    public boolean deleteVideo(Video video) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Video v = (Video) session.get(Video.class, video.getVideo_id());
            session.delete(v);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 更新指定视频表的信息
     * @param video 提供视频更新信息
     * @return
     */
    @Override
    public boolean updateVideo(Video video) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(video);
            return true;
        } catch (Exception e) {
            System.out.println("修改失败！\n错误原因：" + e.getMessage());
            return false;
        }
    }

    /**
     * 视频的模糊查询
     * @param video 提供视频名
     * @return List
     */
    @Override
    public List<Member> searchVideoBack(Video video) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from video where video_title like '%" + video.getVideo_title() + "%'";
        Query query = session.createQuery(hql);
        return (List<Member>) query.list();
    }
}
