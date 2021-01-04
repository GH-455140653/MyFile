package com.example.BLL;

import android.app.Activity;

import com.example.DAL.UserDAL;
import com.example.Model.User;

import java.util.List;

public class UserBLL {
    UserDAL userDAL = new UserDAL();

    public void createUser(String name_ed, String tel_ed, String address_ed, String idNum_ed, String date_ed, String sex, Activity activity) {
        userDAL.insert(name_ed, tel_ed, address_ed, idNum_ed, date_ed, sex, activity);
    }

    public void modifyUserMsg(String name_ed, String tel_ed, String address_ed, String idNum_ed, String date_ed, String sex, int id, Activity activity) {
        userDAL.update(name_ed, tel_ed, address_ed, idNum_ed, date_ed, sex, id, activity);
    }

    public List<User> getUserIdAndName(Activity activity) {
        return userDAL.getIDAndName(activity);
    }

    public List<User> getUser(Activity activity) {
        return userDAL.getUser(activity);
    }

    public void deleteUser(int id, Activity activity) {
        userDAL.delete(id, activity);
    }
}
