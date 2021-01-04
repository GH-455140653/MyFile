/**
 * @ProjectName: [NGU]
 * @Package: [com.NGU.ssh.Service]
 * @ClassName: [VideoService]
 * @Description: [视频模块的业务逻辑处理类]
 * @Author: [lrl]
 * @CreateDate: [2020/11/15 15:17]
 */
package com.NGU.ssh.Service;

import com.NGU.ssh.DAO.VideoDao;
import com.NGU.ssh.Model.Classify;
import com.NGU.ssh.Model.Member;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class VideoService {
    private VideoDao videoDao;
    @Resource
    private ClassifyService classifyService;

    public VideoDao getVideoDao() {
        return videoDao;
    }

    @Resource
    public void setVideoDao(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    /**
     * 视频存入
     * @param file 文件
     * @param fileFileName 文件名
     * @param video 前台获取的模型数据
     * @param classify 分类名
     * @return boolean
     * @throws IOException 异常处理
     */
    @Transactional
    public boolean videoSave(File[] file, String[] fileFileName, Video video, Classify classify) throws IOException {
        if (null != fileFileName) {
            //生成添加视频的时间
            Date date = new Date();

            // 保存到指定目录下
            String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");//获取服务器所在地址/upload (在本机中的绝对地址)
            System.out.println("文件上传路径：" + uploadPath);

            //文件夹判断
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                //创建该目录
                dir.mkdir();
            }

            //循环读写文件
            for (int i = 0; i < file.length; i++) {
                // 保存上传的文件，通过apache提供的工具类来操作
                FileUtils.copyFile(file[i], new File(uploadPath, fileFileName[i]));
                System.out.println(fileFileName[i] + "文件上传成功！");
                if (i == 0) {
                    //存下封面
                    video.setVideo_cover(fileFileName[i]);
                } else {
                    //存下视频
                    video.setVideo_name(fileFileName[i]);
                }
            }

            //存下日期,C_id,
            video.setVideo_date(date);
            video.setC_id(classify.getC_id());

            //视频存入是否成功
            boolean saveFlag = videoDao.saveVideo(video);
            if (saveFlag) {
                System.out.println("视频相关写入数据库！");
                getVideoMsg();
                return true;
            }
        }
        System.out.println("没有文件！");
        return false;
    }

    /**
     * 视频更新
     * @param video 前台视频相关数据
     * @return boolean
     */
    @Transactional
    public boolean videoUpdate(Video video) {
        List<Video> videosList = videoDao.getVideosMsg();
        for (Video v : videosList) {
            if (v.getVideo_id() == video.getVideo_id()
                    && !v.getVideo_title().equals("")
                    && !v.getVideo_desc().equals("")) {
                System.out.println("没有需要修改的东西！");
                ActionContext.getContext().put("errorMsg", "请在文本框输入你需要修改的字段!");
                return false;
            } else {
                videoDao.updateVideo(video);
                getVideoMsg();
                classifyService.getClassList();
                return true;
            }
        }
        return false;
    }

    /**
     * 视频删除
     * @param video 前台传来的视频id
     * @return boolean
     */
    @Transactional
    public boolean videoDelete(Video video) {
        boolean flag = videoDao.deleteVideo(video);
        getVideoMsg();
        return flag;
    }

    /**
     * 数据获取与刷新
     */
    @Transactional(readOnly = true)
    public void getVideoMsg() {
        List<Video> videosList = videoDao.getVideosMsg();

        //刷新视频表
        ActionContext.getContext().getSession().put("videosList", videosList);
        //刷新分类表
        classifyService.getClassList();
    }

    /**
     * 多表查询指定字段
     */
    @Transactional(readOnly = true)
    public void getCVList() {
//        List<Object[]> cvMsg = videoDao.getCVMsg();
//        Iterator<Object[]> iterator = cvMsg.iterator();
//        while (iterator.hasNext()) {
//            Object[] o = iterator.next();
//            Video v = (Video) o[0];
//            Classify c = (Classify) o[1];
//            System.out.println("视频标题：" + ((Video) o[0]).getVideo_title() + "分类名：" + ((Classify) o[1]).getC_name());
//        }
//        ActionContext.getContext().getSession().put("videosList", cvMsg);
    }

    @Transactional(readOnly = true)
    public void getMoreVideo() {
        List<Video> list = videoDao.getCVMsg();
        for (Video v : list) {
            System.out.println(v.getVideo_title());
            System.out.println(v.getVideo_name());
        }
    }


    /**
     * 观看记录
     * @param member 提供用户账号
     * @param video 提供视频id
     * @return boolean
     */
    @Transactional
    public boolean saveVideoPlayRecord(Member member, Video video) {
        Date date = new Date();
        Record record = new Record();
        record.setVideo_id(video.getVideo_id());
        record.setPlaytime(date);
        record.setMember_account(member.getMember_account());
        ActionContext.getContext().getSession().put("VideoID", video.getVideo_id());
        return videoDao.saveVideoPlayMsg(record);
    }

    /**
     * 视频精准查询
     * @param member 提供用户账号
     * @param video 提供视频id和视频名
     * @return boolean
     */
    @Transactional
    public boolean videoSearch(Member member, Video video) {
        List<Video> videos = videoDao.getVideosMsg();
        for (Video v : videos) {
            if (video.getVideo_title().equals(v.getVideo_title())) {
                video.setVideo_id(v.getVideo_id());
                return saveVideoPlayRecord(member, video);
            }
        }
        //没找到改名字的视频
        ActionContext.getContext().put("errorMsg", "没有该视频！");
        return false;
    }

    /**
     * 视频模糊查询
     * @param video 提供视频名
     * @return boolean
     */
    @Transactional
    public boolean videoSearchBack(Video video) {
        List<Member> videos = videoDao.searchVideoBack(video);
        if (videos != null) {
            ActionContext.getContext().getSession().put("videosList", videos);
            return true;
        }
        return false;
    }
}
