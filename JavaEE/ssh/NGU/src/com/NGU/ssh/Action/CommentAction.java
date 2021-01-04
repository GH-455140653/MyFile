package com.NGU.ssh.Action;

import com.NGU.ssh.Model.Comment;
import com.NGU.ssh.Model.Member;
import com.NGU.ssh.Model.Video;
import com.NGU.ssh.Service.CommentService;
import com.opensymphony.xwork2.ActionSupport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
public class CommentAction extends ActionSupport {
    private CommentService commentService;

    private Comment comment;
    private Member member;
    private Video video;

    private String tempString; //选择的复选框的id

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getTempString() {
        return tempString;
    }

    public void setTempString(String tempString) {
        this.tempString = tempString;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    @Resource
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public Comment getComment() {
        return comment;
    }

    @Resource
    public void setComment(Comment comment) {
        this.comment = comment;
    }

    //添加评论
    public String addComment() {
        boolean flag_add = commentService.addComment(comment, member, video);
        boolean flag_get = commentService.findCommentById(video);   //查询指定视频id的评论
        if (flag_add && flag_get) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    //批量删除
    public String deleteSelectMember() {
        String[] result = tempString.split(",");
        int[] array = new int[result.length];
        //将sting转化为int
        for (int i = 0; i < result.length; i++) {
            array[i] = Integer.parseInt(result[i]);
        }
        boolean flag = commentService.deleteSelectMember(array);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    //获取全部数据
    public String findData() {
        //查出所有评论
        boolean flag = commentService.findComment();
        if (flag) {
            //进行分页
            commentService.comment_Page(commentService.getCommentMsg());
            return SUCCESS;
        }
        return ERROR;
    }

    //分页
    public String commentPagination() {
        commentService.comment_Page(commentService.getCommentMsg());
        return SUCCESS;
    }
}
