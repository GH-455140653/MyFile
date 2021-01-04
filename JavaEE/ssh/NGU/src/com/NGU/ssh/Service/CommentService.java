package com.NGU.ssh.Service;

import com.NGU.ssh.DAO.CommentDao;
import com.NGU.ssh.Model.Comment;
import com.NGU.ssh.Model.Member;
import com.NGU.ssh.Model.Video;
import com.opensymphony.xwork2.ActionContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
public class CommentService {
    private CommentDao commentDao;

    public CommentDao getCommentDao() {
        return commentDao;
    }

    @Resource
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

//    @Transactional
//    public int findTotalRecords() {
//        return commentDao.findTotalRecordsDao();
//    }
//
//    @Transactional
//    public List<Comment> findShowRecords(int pageNow, int pageSize) {
//        int skipRecords = (pageNow - 1) * pageSize;    //数据库查询跳过的记录数
//        return commentDao.findShowRecordsDao(skipRecords, pageSize);
//    }

    //删除所选用户信息
    @Transactional
    public boolean deleteSelectMember(int[] accounts) {
        boolean flag = commentDao.deleteMember(accounts);
        if (flag) {
            List<Comment> commentList = getCommentMsg();
            ActionContext.getContext().put("commentList", commentList);
            return true;
        } else {
            return false;
        }
    }

    //添加评论
    @Transactional
    public boolean addComment(Comment comment, Member member, Video video) {
        //获取当前时间
        Date date = new Date();

        comment.setComment_post(date);
        comment.setMember_account(member.getMember_account());
        comment.setVideo_id(video.getVideo_id());
        return commentDao.saveComment(comment);
    }

    //查询指定视频的评论
    @Transactional
    public boolean findCommentById(Video video) {
        List<Comment> commentList = commentDao.getCommentbyId(video.getVideo_id());
        ActionContext.getContext().getSession().put("commentList", commentList);
        return true;
    }

    //分页查询全部数据
    @Transactional(readOnly = true)
    public boolean findComment() {
        List<Comment> commentList = getCommentMsg();
        ActionContext.getContext().getSession().put("commentList", commentList);
        return true;
    }

    //查全部
    @Transactional(readOnly = true)
    public List<Comment> getCommentMsg() {
        return commentDao.find();
    }

    // 实现分页
    public void comment_Page(List<Comment> commentList) {
        int pageNos; // 当前页数
        int count;
        if (commentList != null) {
            count = commentList.size();// 总条数
        } else {
            count = 0;
        }
        System.out.println("修改总条数为:" + count);
        int countPage;// 总页数
        // 取决于每页的数目奇数还是偶数，现在为偶数
        if (count % 2 == 0) {
            countPage = count / 2;// 每页两条数目的总页数
            System.out.println(count + "总条数");
            System.out.println(countPage + "总页数");
        } else {
            countPage = count / 2 + 1;
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("pageNos") == null || Integer.parseInt(request.getParameter("pageNos")) < 1) {
            pageNos = 1;
        } else {
            pageNos = Integer.parseInt(request.getParameter("pageNos"));
        }
        System.out.println("当前页数为" + pageNos);
        ActionContext.getContext().getSession().put("pageNos", pageNos);
        request.setAttribute("commentList", commentList);
        ActionContext.getContext().getSession().put("countPage", countPage);
    }
}
