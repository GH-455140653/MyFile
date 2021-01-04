package com.NGU.ssh.DAO.Imp;

import com.NGU.ssh.DAO.MemberDao;
import com.NGU.ssh.Model.Member;
import com.NGU.ssh.Model.Member_logindate;
import com.NGU.ssh.Model.Record;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MemberDaoImp implements MemberDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 获取所有用户所有信息
     * @return List
     */
    @Override
    public List<Member> getAllMember() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from member");
        return (List<Member>) query.list();
    }

    /**
     * 获取所有用户的账号
     * @return lList<Member>
     */
    @Override
    public List<Member> getMemberActMsg() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select member_account from member");
        return (List<Member>) query.list();
    }

    @Override
    public boolean saveMember(Member member) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(member);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateMember(Member member) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(member);
            System.out.println("密码修改成功！");
            return true;
        } catch (Exception e) {
            System.out.println("修改失败！\n错误原因：" + e.getMessage());
            return false;
        }
    }

    /**
     * 记录用户登录时间
     * @param memberLoginDate 用户登录模型
     */
    @Override
    public void saveMemberLoginDate(Member_logindate memberLoginDate) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(memberLoginDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 批量删除选定用户
     * @param acts 选中的用户名数组
     * @return boolean
     */
    @Override
    public boolean deleteMember(String[] acts) {
        Session session = sessionFactory.getCurrentSession();
        try {
            for (String act : acts) {
                Member member = (Member) session.get(Member.class, act);
                session.delete(member);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 模糊查询指定用户的信息
     * @param name 用户名
     * @return List
     */
    @Override
    public List<Member> searchMember(String name) {
        Session sessioni = sessionFactory.getCurrentSession();
        String hql = "from member where member_name like '%" + name + "%'";
        Query query = sessioni.createQuery(hql);
        return (List<Member>) query.list();
    }

    /**
     * 获得所有浏览记录信息
     * @return List
     */
    @Override
    public List<Record> getRecordMsg() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from record");
        return (List<Record>) query.list();
    }

    /**
     * 统计指定视频的播放次数
     * @param videoId 视频Id
     * @return Long
     */
    @Override
    public Long videoClickCount(int videoId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from record where video_id=" + videoId);
        return (Long) query.uniqueResult();
    }

    /**
     * 获取所有用户的账号和密码信息
     * @return List<Member>
     */
    @Override
    public List<Member> getLoginMemberMsg() {
        Session session = sessionFactory.getCurrentSession();
        String hql ="";
        Query query = session.createQuery(hql);
        return (List<Member>) query.list();
    }

    /**
     * 获得指定用户浏览记录
     */
    @Override
    public List<Record> getBrowseMsg(String userAccount) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from record where member_account='" + userAccount+"'";
        Query query = session.createQuery(hql);
        return (List<Record>) query.list();
    }
}
