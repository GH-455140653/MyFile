package com.NGU.ssh.DAO.Imp;

import com.NGU.ssh.DAO.ClassifyDao;

import com.NGU.ssh.Model.Classify;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ClassifyDaoImp implements ClassifyDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Classify> getClassMsg() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from classify");
        return (List<Classify>) query.list();
    }

    @Override
    public boolean addClassify(Classify classify) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(classify);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteClassify(Classify classify) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Classify c = (Classify) session.get(Classify.class, classify.getC_id());
            session.delete(c);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateClassify(Classify classify) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(classify);
            return true;
        } catch (Exception e) {
            System.out.println("修改失败！\n错误原因：" + e.getMessage());
            return false;
        }
    }
}
