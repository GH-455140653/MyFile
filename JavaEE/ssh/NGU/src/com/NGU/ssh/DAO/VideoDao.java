package com.NGU.ssh.DAO;

import com.NGU.ssh.Model.Member;
import com.NGU.ssh.Model.Record;
import com.NGU.ssh.Model.Video;

import java.util.List;

public interface VideoDao {
    boolean saveVideo(Video video);

    List<Video> getVideosMsg();

    boolean saveVideoPlayMsg(Record record);

    boolean deleteVideo(Video video);

    boolean updateVideo(Video video);

    List<Member> searchVideoBack(Video video);

    List<Video> getCVMsg();
}
