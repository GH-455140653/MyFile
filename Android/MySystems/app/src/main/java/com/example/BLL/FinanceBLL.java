package com.example.BLL;

import com.example.DAL.FinanceDAL;
import com.example.Model.Finance;
import com.example.Model.House;
import com.example.Model.User;
import com.example.mysystems.FinanceActivity;
import com.example.mysystems.Finance_add;
import com.example.mysystems.Finance_show;

import java.util.List;

public class FinanceBLL {
    UserBLL userBLL = new UserBLL();
    FinanceDAL financeDAL = new FinanceDAL();
    HouseBLL houseBLL = new HouseBLL();

    public List<Finance> getFinanceMsgByHid(String hid, FinanceActivity financeActivity) {
        List<User> userList = userBLL.getUserIdAndName(financeActivity);
        return financeDAL.getMsgByHid(hid, userList, financeActivity);
    }

    public void deleteFinanceMsg(String hid, String uid, String time, FinanceActivity financeActivity) {
        financeDAL.delete(hid, uid, time, financeActivity);
    }

    public List<Finance> getFinanceMsg(FinanceActivity financeActivity) {
        List<User> userList = userBLL.getUserIdAndName(financeActivity);
        return financeDAL.getMsg(userList, financeActivity);
    }

    public List<User> getUserList(Finance_add finance_add) {
        return userBLL.getUserIdAndName(finance_add);
    }

    public List<House> getHouseList(Finance_add finance_add) {
        return houseBLL.getCustomerList(finance_add);
    }

    public void financeAdd(String hid, String uid, String time, float electricity, float water, float netRant, float houseRant, float summary, Finance_add finance_add) {
        financeDAL.addFinance(hid, uid, time, electricity, water, netRant, houseRant, summary, finance_add);
    }

    public void EandWAdd(String hid, String uid, String date, float preEle, float preWat, float nowEle, float nowWat, float ele, float wat, float lastEle, float lastWat, Finance_add finance_add) {
        financeDAL.addEandW(hid, uid, date, preEle, preWat, nowEle, nowWat, ele, wat, lastEle, lastWat, finance_add);
    }

    public List<Finance> getEandWMsg(String houseNum, String userId, Finance_add finance_add) {
        return financeDAL.getEandW(houseNum, userId, finance_add);
    }

    public List<String> getFinanceItemsList(String hid, String uid, String time, Finance_show finance_show) {
        return financeDAL.getItemsList(hid, uid, time, finance_show);
    }

    public String[] getEandW_waterMsg(String hid, String uid, String time, Finance_show finance_show) {
        return financeDAL.getWaterMsg(hid, uid, time, finance_show);
    }

    public String[] getEandW_electricity(String hid, String uid, String time, Finance_show finance_show) {
        return financeDAL.getElectricityMsg(hid, uid, time, finance_show);
    }

    public List<Finance> getAddMsgBefore(String username, String hid, String date, Finance_add finance_add) {
        List<User> userList = userBLL.getUserIdAndName(finance_add);
        return financeDAL.getAddBeforeMsg(username, hid, date, userList, finance_add);
    }

    public boolean getFianceDate(String hid, String username, String date, Finance_add finance_add) {
        List<User> userList = userBLL.getUserIdAndName(finance_add);
        return financeDAL.getDate(hid, username, date, userList, finance_add);
    }
}
