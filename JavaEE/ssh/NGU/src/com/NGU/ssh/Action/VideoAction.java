/**
 * @ProjectName: [NGU]
 * @Package: [com.NGU.ssh.Action]
 * @ClassName: [VideoAction]
 * @Description: [视频模块的前台数据接收类]
 * @Author: [lrl]
 * @CreateDate: [2020/11/25 15:02]
 */
package com.NGU.ssh.Action;

import com.NGU.ssh.Model.*;
import com.NGU.ssh.Service.CommentService;
import com.NGU.ssh.Service.VideoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Component
@Scope("prototype")
public class VideoAction extends ActionSupport {
    private Video video;
    private Record record;
    private Member member;
    private Comment comment;
    private Classify classify;

    private File[] file;
    private String[] fileFileName;

    private VideoService videoService;
    private CommentService commentService;

    public Member getMember() {
        return member;
    }

    @Resource
    public void setMember(Member member) {
        this.member = member;
    }

    public Record getRecord() {
        return record;
    }

    public Comment getComment() {
        return comment;
    }

    @Resource
    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Resource
    public void setRecord(Record record) {
        this.record = record;
    }

    public Classify getClassify() {
        return classify;
    }

    @Resource
    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public Video getVideo() {
        return video;
    }

    @Resource
    public void setVideo(Video video) {
        this.video = video;
    }

    public VideoService getVideoService() {
        return videoService;
    }

    @Resource
    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    @Resource
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public File[] getFile() {
        return file;
    }

    public void setFile(File[] file) {
        this.file = file;
    }

    public String[] getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String[] fileFileName) {
        this.fileFileName = fileFileName;
    }

    /*上传视频*/
    public String videoAdd() throws IOException {
        boolean flag = videoService.videoSave(file, fileFileName, video, classify);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /*更新视频相关数据*/
    public String videoUpdate() {
        boolean flag = videoService.videoUpdate(video);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /*删除指定的已上传视频*/
    public String videoDelete() {
        boolean flag = videoService.videoDelete(video);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /*数据刷新*/
    public void dateUpdate() {
        videoService.getVideoMsg();
    }

    /*视频播放记录相关数据*/
    public String videoPlay() {
        boolean flag_comment = commentService.findCommentById(video);   //查询指定视频id的
        boolean flag_video = videoService.saveVideoPlayRecord(member, video);
        if (flag_video && flag_comment) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /*视频精准查询*/
    public String videoSearch() {
        boolean flag = videoService.videoSearch(member, video);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /*视频模糊查询*/
    public String searchVideoBack() {
        boolean flag = videoService.videoSearchBack(video);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /*视频查询*/
    public String read() {
        videoService.getVideoMsg();
//        videoService.getMoreVideo();
        return SUCCESS;
    }

    /*视频数据更新*/
    public void dataUpdate() {
        videoService.getVideoMsg();
    }
}
