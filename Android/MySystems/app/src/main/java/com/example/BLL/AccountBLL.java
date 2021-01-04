package com.example.BLL;


import android.app.Activity;

import com.example.DAL.AccountDAL;
import com.example.Model.Account;

import java.util.List;


public class AccountBLL {
    AccountDAL accountDAL = new AccountDAL();

    public List<Account> getAccountAll(Activity activity) {
        return accountDAL.getList(activity);
    }

    public List<Account> getAccountName(Activity activity) {
        return accountDAL.getNameList(activity);
    }

    public void createAccount(String act, String pwd, Activity activity) {
        accountDAL.insert(act, pwd, activity);
    }

    public List<Account> getAccountIdAndName(Activity activity) {
        return accountDAL.getIdAndName(activity);
    }

    public void modifyAccount(String act, String pwd, int id, Activity activity) {
        accountDAL.update(act,pwd,id,activity);
    }
}
