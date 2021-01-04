package com.NGU.ssh.Action;

import com.NGU.ssh.Model.Classify;
import com.NGU.ssh.Service.ClassifyService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
public class ClassifyAction extends ActionSupport {
    private Classify classify;
    private ClassifyService classifyService;

    public ClassifyService getClassifyService() {
        return classifyService;
    }

    @Resource
    public void setClassifyService(ClassifyService classifyService) {
        this.classifyService = classifyService;
    }

    public Classify getClassify() {
        return classify;
    }

    @Resource
    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public String add() {
        boolean flag = classifyService.addClass(classify);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String update() {
//        System.out.println(classify.getC_name());
        boolean flag = classifyService.updateClass(classify);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String delete() {
        boolean flag = classifyService.deleteClass(classify);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public void foregroundDate() {
        classifyService.getClassList();
    }

    public String read() {
        foregroundDate();
        return SUCCESS;
    }
}
