package com.example.BLL;

import android.app.Activity;

import com.example.DAL.HouseDAL;
import com.example.Model.House;

import java.util.List;

public class HouseBLL {
    HouseDAL houseDAL = new HouseDAL();

    public void modifyHouseNum(String uid, String hid, Activity activity) {
        houseDAL.update(uid, hid, activity);
    }

    public List<House> getHouseMsg(Activity activity) {
        return houseDAL.getHouseAll(activity);
    }

    public List<House> getHouseId(Activity activity) {
        return houseDAL.getId(activity);
    }

    public void createHouse(String hid, String hSize, Activity activity) {
        houseDAL.insert(hid, hSize, activity);
    }

    public void deleteHouse(int hid, Activity activity) {
        houseDAL.delete(hid, activity);
    }

    public List<House> getCustomerList(Activity activity) {
        return houseDAL.getCustomerMsg(activity);
    }
}
