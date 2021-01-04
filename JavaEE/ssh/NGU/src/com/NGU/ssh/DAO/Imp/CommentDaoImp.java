package com.NGU.ssh.DAO.Imp;

import com.NGU.ssh.DAO.CommentDao;
import com.NGU.ssh.Model.Comment;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.Resource;


@Component
public class CommentDaoImp implements CommentDao {


    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    //查询
    @Override
    public List<Comment> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from comment");
        return (List<Comment>) query.list();
    }

    //查询指定视频id的用户
    public List<Comment> getCommentbyId(int id) {
        Session sessioni = sessionFactory.getCurrentSession();
        Query query = sessioni.createQuery("from comment where video_id = " + id);
        return (List<Comment>) query.list();
    }

    //删除选定评论信息
    @Override
    public boolean deleteMember(int[] ids) {
        Session session = sessionFactory.getCurrentSession();
        try {
            for (int i = 0; i < ids.length; i++) {
                Comment comment = (Comment) session.get(Comment.class, ids[i]);
                session.delete(comment);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //添加评论
    @Override
    public boolean saveComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(comment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    //分页
//    @Override
//    public int findTotalRecordsDao() {
//        Session session = sessionFactory.getCurrentSession();    //获取session
//        try {
//            return session.createQuery("from comment").list().size();//返回记录条数
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    //分页
//    @Override
//    public List<Comment> findShowRecordsDao(int skipRecords, int pageSize) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from comment");
//        query.setFirstResult(skipRecords);//指定从哪一条记录开始查
//        query.setMaxResults(pageSize);     //设置要查找的记录数
//        return (List<Comment>) query.list();
//    }
}
