/**
 * @author:朱思博
 * @date:2020/11/18-{15:37}
 */
package com.NGU.ssh.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "comment")
public class Comment {
    private int comment_id;//评论id
    private int video_id;//评论所属的视频id     外键  视频id
    private String member_account;//外键  普通用户的账号
    private String comment_text;//评论的内容
    private Date comment_post;//该条评论的发布时间

    @Id
    @GeneratedValue
    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }
    
    public String getMember_account() {
        return member_account;
    }

    public void setMember_account(String member_account) {
        this.member_account = member_account;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Date getComment_post() {
        return comment_post;
    }

    public void setComment_post(Date comment_post) {
        this.comment_post = comment_post;
    }
}
