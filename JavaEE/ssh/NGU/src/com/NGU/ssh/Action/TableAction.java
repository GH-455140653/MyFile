package com.NGU.ssh.Action;

import com.NGU.ssh.Model.Member_logindate;
import com.NGU.ssh.Model.Video;
import com.NGU.ssh.Service.TableService;
import com.opensymphony.xwork2.ActionSupport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
public class TableAction extends ActionSupport{
    private Video video;
    private Member_logindate member_logindate;
    private TableService tableService;

    
    
//    private int text;//测试局部刷新用的数据
//    public int getText() {
//		return text;
//	}
//	public void setText(int text) {
//		this.text = text;
//	}

	
	
	public String getUserList() {
        Boolean flag = tableService.getUser();
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
    
	
    
    
    
    
    
    public String getVideoList() {
    	Boolean flag = tableService.getVideo();
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
   
    /*
     * 
     * 获取每天的各个分类的上传量
     * 
     */
    
    public Video getVideo() {
        return video;
    }

    @Resource
    public void setVideo(Video video) {
        this.video = video;
    }

    public Member_logindate getMember_logindate() {
        return member_logindate;
    }

    @Resource
    public void setMember_logindate(Member_logindate member_logindate) {
        this.member_logindate = member_logindate;
    }

    public TableService getTableService() {
        return tableService;
    }

    @Resource
    public void setTableService(TableService tableService) {
        this.tableService = tableService;
    }
    
}
