package com.NGU.ssh.DAO;

import com.NGU.ssh.Model.Member;
import com.NGU.ssh.Model.Member_logindate;
import com.NGU.ssh.Model.Record;

import java.util.List;

public interface MemberDao {
    Long videoClickCount(int videoId);//对视频id进行计数

    boolean saveMember(Member member);

    boolean updateMember(Member member);

    boolean deleteMember(String[] ids);

    void saveMemberLoginDate(Member_logindate member_logindate);

    List<Member> getAllMember();//获取所有用户表信息

    List<Member> getMemberActMsg();//获取所有用户账号

    List<Member> searchMember(String name);//查询用户

    List<Record> getRecordMsg();//获得用户浏览记录

    List<Record> getBrowseMsg(String userAccount);//获得用户浏览记录

    List<Member> getLoginMemberMsg();//获取用户的账号和密码
}
