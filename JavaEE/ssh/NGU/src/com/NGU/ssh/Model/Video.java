/**
 * @author:朱思博
 * @date:2020/11/18-{15:37}
 */
package com.NGU.ssh.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.stereotype.Component;


@Component
@Entity(name = "video")
public class Video {
    private int video_id;//视频id
    private int c_id;//视频所属的分类id	数据库中的外键
    private String video_title;//视频的标题
    private String video_cover;//视频封面地址
    private String video_name;//视频地址
    private Date video_date;//视频的上传日期 对应数据库中datetime
    private String video_desc;//视频的描述

    private Set<Record> records = new HashSet<Record>();//视频表和观看记录表的一对多   一个视频可以有多个观看记录     一条观看记录只能属于一个视频
    private Set<Comment> comments = new HashSet<Comment>();//视频表和评论表的一对多   一个视频可以有多个评论     一条评论只能属于一个视频

    public Video(){
        super();
    }

    public Video(String video_title,String video_name){
        super();
        this.video_title = video_title;
        this.video_name = video_name;
    }

    @Id
    @GeneratedValue
    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_cover() {
        return video_cover;
    }

    public void setVideo_cover(String video_cover) {
        this.video_cover = video_cover;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public Date getVideo_date() {
        return video_date;
    }

    public void setVideo_date(Date video_date) {
        this.video_date = video_date;
    }

    public String getVideo_desc() {
        return video_desc;
    }

    public void setVideo_desc(String video_desc) {
        this.video_desc = video_desc;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "video_id", updatable = false)      //视频表的主键对应记录表的外键：video_id
    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "video_id", updatable = false)      //视频表的主键对应评论表的外键：video_id
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
