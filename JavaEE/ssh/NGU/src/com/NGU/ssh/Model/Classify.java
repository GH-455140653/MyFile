/**
 * @author:朱思博
 * @date:2020/11/18-{15:37}
 */
package com.NGU.ssh.Model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
@Entity(name = "classify")
public class Classify {
    private int c_id;//二级分类id
    private String c_name;//二级分类的名称

    //视频表和分类表的一对多,一个分类有多个视频
    private Set<Video> videos = new HashSet<Video>();

    @Id
    @GeneratedValue
    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "c_id", updatable = false)
    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }


    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}
