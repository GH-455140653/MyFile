package com.NGU.ssh.Action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.NGU.ssh.Model.Member;
import com.NGU.ssh.Service.MemberService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.io.File;


@Component
@Scope("prototype")
public class MemberAction extends ActionSupport {
    private Member member; //前台的模型数据获取与存储
    private MemberService memberService; //方法处理类

    private String tempString; //用户管理界面 checkbox为true的用户账号

    private File file; //上传文件
    private String fileFileName; //上传文件名

    public String login() {
        boolean flag = memberService.memberLogin(member);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String pwdForget() {
        boolean flag = memberService.memberPwdForget(member);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String pwdModify() {
        boolean flag = memberService.memberPwdModify(member);
        if (flag) {
            return SUCCESS;
        } else {
            ActionContext.getContext().put("errorMsg", "用户密码修改：遇到未知错误，请及时练习网站负责人！");
            return ERROR;
        }
    }

    public String register() {
        boolean flag = memberService.memberRegister(member, file, fileFileName);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String getAllMember() {//获得全部用户信息
        memberService.getMembersMsg();
        return SUCCESS;
    }

    public String searchMember() {//获得全部用户信息
        boolean flag = memberService.searchMember(member);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String deleteSelectMember() {//批量删除
        String[] result = tempString.split(",");
        boolean flag = memberService.deleteSelectMember(result);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String memberPagination() {
        return null;
    }

    public String videoBrowse() {//获得用户视频浏览信息
        boolean flag = memberService.getBrowse(member);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


    public String getTempString() {
        return tempString;
    }

    public void setTempString(String tempString) {
        this.tempString = tempString;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Member getMember() {
        return member;
    }

    @Resource
    public void setMember(Member member) {
        this.member = member;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    @Resource
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
}
