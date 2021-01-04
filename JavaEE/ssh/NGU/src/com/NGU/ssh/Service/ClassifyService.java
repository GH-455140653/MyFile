package com.NGU.ssh.Service;

import com.NGU.ssh.DAO.ClassifyDao;
import com.NGU.ssh.Model.Classify;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ClassifyService {
    private ClassifyDao classifyDao;

    @Resource
    VideoService videoService;

    public ClassifyDao getClassifyDao() {
        return classifyDao;
    }

    @Resource
    public void setClassifyDao(ClassifyDao classifyDao) {
        this.classifyDao = classifyDao;
    }

    @Transactional
    public boolean addClass(Classify classify) {
        List<Classify> classList = classifyDao.getClassMsg();
        if (classList.size() != 0) {
            for (Classify c : classList) {
                if (c.getC_name().equals(classify.getC_name())) {
                    //重复不插
                    System.out.println("该分类已存在!");
                    return false;
                }
            }
            //非重复插入
            classifyDao.addClassify(classify);
            getClassList();
            return true;
        } else {
            //无值时插入
            classifyDao.addClassify(classify);
            getClassList();
            return true;
        }
    }

    @Transactional
    public boolean updateClass(Classify classify) {
        List<Classify> classList = classifyDao.getClassMsg();
        for (Classify c : classList) {
            if (classify.getC_name().equals(c.getC_name())) {
                System.out.println("该分类已存在！");
                return false;
            }
        }
        classifyDao.updateClassify(classify);
        getClassList();
        return true;
    }

    @Transactional
    public boolean deleteClass(Classify classify) {
        boolean flag = classifyDao.deleteClassify(classify);
        getClassList();
        videoService.getVideoMsg();
        return flag;
    }

    @Transactional(readOnly = true)
    public void getClassList() {
        List<Classify> classList = classifyDao.getClassMsg();
        ActionContext.getContext().getSession().put("classList", classList);
    }
}
