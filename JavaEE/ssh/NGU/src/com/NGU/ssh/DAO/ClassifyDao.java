package com.NGU.ssh.DAO;

import com.NGU.ssh.Model.Classify;

import java.util.List;

public interface ClassifyDao {

    List<Classify> getClassMsg();

    boolean addClassify(Classify classify);

    boolean deleteClassify(Classify classify);

    boolean updateClassify(Classify classify);

}
