package com.NGU.ssh.DAO;

import java.util.List;

import com.NGU.ssh.Model.Comment;

public interface CommentDao {
    //获取所有
    List<Comment> find();

    //删除
    boolean deleteMember(int[] ids);

    //查找指定视频id的评论
    List<Comment> getCommentbyId(int id);

    //添加评论
    boolean saveComment(Comment comment);

//    //分页
//    public int findTotalRecordsDao();
//    public List<Comment> findShowRecordsDao(int skipRecords, int pageSize);

}
