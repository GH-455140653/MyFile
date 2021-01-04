package com.NGU.ssh.Service;

import com.NGU.ssh.DAO.MemberDao;
import com.NGU.ssh.DAO.VideoDao;
import com.NGU.ssh.Model.Member;
import com.NGU.ssh.Model.Member_logindate;
import com.NGU.ssh.Model.Record;
import com.NGU.ssh.Model.Video;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Component
public class MemberService {
    private MemberDao memberDao;
    @Resource
    private VideoDao videoDao;

    public MemberDao getMemberDao() {
        return memberDao;
    }

    @Resource
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    /**
     * 用户登录
     *
     * @param member 成员信息（账号，密码）
     * @return boolean
     */
    @Transactional
    public boolean memberLogin(Member member) {
        List<Member> membersList = memberDao.getAllMember();
        for (Member member_item : membersList) {
            if (member_item.getMember_account().equals(member.getMember_account())
                    && member_item.getMember_password().equals(member.getMember_password())) {

                //记录用户登录时间
                Member_logindate member_logindate = new Member_logindate();
                Date date = new Date();
                member_logindate.setMember_account(member.getMember_account());
                member_logindate.setLogin_date(date);
                memberDao.saveMemberLoginDate(member_logindate);

                //写入session用于页面切换
                ActionContext.getContext().getSession().put("memberAccount", member_item.getMember_account());
                ActionContext.getContext().getSession().put("memberName", member_item.getMember_name());
                ActionContext.getContext().getSession().put("memberImage", member_item.getMember_icon());
                return true;
            }
        }
        ActionContext.getContext().put("errorMsg", "账号或密码登录有误！");
        return false;
    }

    /**
     * 用户注册
     * @param member 成员信息(账号，密码，昵称，图片)
     * @param file 图片文件
     * @param fileFileName 图片文件名
     * @return boolean
     */
    @Transactional
    public boolean memberRegister(Member member, File file, String fileFileName) {
        List<Member> memberList = memberDao.getMemberActMsg();
        for (Member m : memberList) {
            if (m.getMember_account().equals(member.getMember_account())) {
                System.out.println("用户注册：该账号名已存在！");
                ActionContext.getContext().put("errorMsg", "用户注册：该账号名已存在！");
                return false;
            }
        }
        if (null != fileFileName) {
            //记录用户注册日期
            Date date = new Date();

            // 保存到指定目录下
            String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");//获取服务器所在地址/upload (在本机中的绝对地址)
            System.out.println("文件上传路径：" + uploadPath);

            //文件夹存在性判断
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                //创建该目录
                dir.mkdir();
            }

            // 保存上传的文件，通过apache提供的工具类来操作
            try {
                //图片上传
                FileUtils.copyFile(file, new File(uploadPath, fileFileName));
                System.out.println("用户注册：" + fileFileName + "文件上传成功！");

                //用户个人信息写入数据库
                member.setMember_icon(fileFileName);
                member.setMember_borndate(date);
                boolean flag = memberDao.saveMember(member);
                System.out.println("用户注册：文件写入成功!");
                return flag;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("用户注册：文件写入失败！");
                ActionContext.getContext().put("errorMsg", "用户注册：文件写入失败！");
                return false;
            }
        }
        System.out.println("用户注册：没有文件！");
        ActionContext.getContext().put("errorMsg", "用户注册：文件上传有误，请重新上传！");
        return false;
    }

    /**
     * 忘记密码
     * @param member 成员信息（用户账号）
     * @return boolean
     */
    @Transactional
    public boolean memberPwdForget(Member member) {
        List<Member> memberList = memberDao.getMemberActMsg();
        for (Member member_get : memberList) {
            if (member.getMember_account().equals(member_get.getMember_account())) {
                member.setMember_password("888888");
                if (memberDao.updateMember(member)) {
                    System.out.println("密码初始化完成！");
                    return true;
                }
                ActionContext.getContext().put("errorMsg", "数据库修改密码失败！");
                return false;
            }
        }
        ActionContext.getContext().put("errorMsg", "没有找到该用户！");
        return false;
    }

    /**
     * 密码修改
     * @param member 成员信息（账号，密码）
     * @return boolean
     */
    @Transactional
    public boolean memberPwdModify(Member member) {
        return memberDao.updateMember(member);
    }

    /**
     * 获取所有用户信息List
     * @return List<Member>
     */
    @Transactional(readOnly = true)
    public List<Member> getMembersList() {
        return memberDao.getAllMember();
    }

    /**
     * 将用户信息List传到前台
     */
    @Transactional(readOnly = true)
    public void getMembersMsg() {
        ActionContext.getContext().getSession().put("membersList", getMembersList());
    }

    /**
     * 删除所选用户信息
     * @param accounts 用户数组
     * @return boolean
     */
    @Transactional
    public boolean deleteSelectMember(String[] accounts) {
        boolean flag = memberDao.deleteMember(accounts);
        if (flag) {
            getMembersMsg();
            return true;
        } else {
            ActionContext.getContext().put("errorMsg","删除用户：遇到未知错误，请及时联系网站负责人！");
            return false;
        }
    }

    /**
     * 模糊查询用户信息
     * @param member _用户名
     * @return boolean
     */
    @Transactional
    public boolean searchMember(Member member) {
        List<Member> list = memberDao.searchMember(member.getMember_name());
        if (list != null) {
            ActionContext.getContext().getSession().put("membersList", list);
            return true;
        }
        ActionContext.getContext().put("errorMsg","模糊查询用户信息：遇到未知错误，请及时联系网站负责人！");
        return false;
    }

    /**
     * 实现用户的浏览记录功能
     * @param member _用户名
     * @return boolean
     */
    @Transactional(readOnly = true)
    public boolean getBrowse(Member member) {         //获得用户浏览信息
        List<Record> membersBrowse_Msg = memberDao.getBrowseMsg(member.getMember_account());
        List<Video> videos_Msg = videoDao.getVideosMsg();
        Map map = new HashMap();
        Map record = new HashMap();
        if (membersBrowse_Msg != null && videos_Msg.size() != 0) {
            for (Record r : membersBrowse_Msg) {
                int clickCount = memberDao.videoClickCount(r.getVideo_id()).intValue();
                map.put(r.getVideo_id(), clickCount);
                ActionContext.getContext().getSession().put("clickMap", map);
                record.put(r.getVideo_id(), r.getPlaytime());
                ActionContext.getContext().getSession().put("recordMap", record);
            }
            ActionContext.getContext().getSession().put("vedioList", videos_Msg);
            return true;
        }
        ActionContext.getContext().put("errorMsg","个人中心：数据库数据检索失败！");
        return false;
    }
}
