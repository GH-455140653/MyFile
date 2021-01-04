package com.NGU.ssh.DAO.Imp;

import com.NGU.ssh.DAO.TableDao;
import com.NGU.ssh.Model.Classify;
import com.NGU.ssh.Model.Member_logindate;
import com.NGU.ssh.Model.Video;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.Resource;

@Component
public class TableDaoImp implements TableDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Video> getVideoMsg() {
        Session sessioni = sessionFactory.getCurrentSession();
        Query query = sessioni.createQuery("from video");
        return (List<Video>) query.list();
    }
    
    @Override
    public List<Member_logindate> getMember_logindateMsg() {
        Session sessioni = sessionFactory.getCurrentSession();
        Query query = sessioni.createQuery("from member_logindate");
        return (List<Member_logindate>) query.list();
    }

	@Override
	public List<Classify> getClassifyMsg() {
		 Session sessioni = sessionFactory.getCurrentSession();
	     Query query = sessioni.createQuery("from classify");
	     return (List<Classify>) query.list();
	}
    
    
}
