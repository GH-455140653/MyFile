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
@Entity(name = "record")
public class Record {
    private int record_id;//记录id
    private int video_id;//外键  视频id
    private String member_account;//外键  普通用户的账号
    private Date playtime;//记录用户观看视频的时间

    @Id
    @GeneratedValue
    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
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

    public Date getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Date playtime) {
        this.playtime = playtime;
    }
}
