package com.NGU.ssh.DAO;

import java.util.List;

import com.NGU.ssh.Model.Classify;
import com.NGU.ssh.Model.Member_logindate;
import com.NGU.ssh.Model.Video;

public interface TableDao {//报表接口
	//接口中定义两个方法
	//获取Video表中数据--用来制作视频报表
	List<Video> getVideoMsg();
	//获取普通用户登录表的数据--用来制作用户报表
    List<Member_logindate> getMember_logindateMsg();
    //获取分类表的数据--用来根据分类id查分类名称
    List<Classify> getClassifyMsg();
}
