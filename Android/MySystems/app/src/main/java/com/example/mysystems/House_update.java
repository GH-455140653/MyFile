package com.example.mysystems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.HouseBLL;
import com.example.BLL.UserBLL;
import com.example.Model.House;
import com.example.Model.User;

import java.util.ArrayList;
import java.util.List;


public class House_update extends AppCompatActivity {
    List<User> userList;
    EditText ed_houseNum, ed_houseSize;
    Spinner sp_userName;
    String houseNum, houseSize, userName;
    Button btn;
    HouseBLL houseBLL = new HouseBLL();
    UserBLL userBLL = new UserBLL();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_update);
        init();
    }


    private void init() {
        //控件获取
        sp_userName = findViewById(R.id.house_update_house_spinner);
        ed_houseNum = findViewById(R.id.house_update_houseNum_ed);
        btn = findViewById(R.id.house_update_btn);
        ed_houseSize = findViewById(R.id.house_update_houseSize_ed);

        //控件数据初始化
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        houseNum = bundle.getString("Hid");
        houseSize = bundle.getString("Size");
        userName = bundle.getString("name", "");
        ed_houseNum.setText(houseNum);
        ed_houseSize.setText(houseSize);

        initSpinner();

    }

    public void update(View view) {
        int Uid = 0;

        List<User> list = getUserList();
        for (User user : list) {
            if (sp_userName.getSelectedItem().toString().equals(user.getName())) {
                Uid = user.getId();
                break;
            }
        }

        if (sp_userName.getSelectedItemId() == 0) {
            if (sp_userName.getSelectedItem().equals(userName)) {
                Toast.makeText(this, userName + "租客已入住" + houseNum, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "请选择入住该房的租客姓名！", Toast.LENGTH_SHORT).show();
            }
        } else {
            house_update(String.valueOf(Uid), houseNum);
            Toast.makeText(this, sp_userName.getSelectedItem() + "成功入住" + houseNum, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    //动态向下拉框存值以及选中事件
    private void initSpinner() {
        userList = getUserList();
        List<String> userNameList = new ArrayList<>();

        if (userName.equals("")) {
            userNameList.add("请选择租客姓名");
            for (User user : userList) {
                userNameList.add(user.getName());
            }
        } else {
            userNameList.add(userName);
            for (User user : userList) {
                if (!userName.equals(user.getName())) {
                    userNameList.add(user.getName());
                }
            }
            btn.setText("修改");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(House_update.this, android.R.layout.simple_spinner_item, userNameList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_userName.setAdapter(adapter);
        sp_userName.setVisibility(View.VISIBLE);
    }

    private void house_update(String uid, String hid) {
        houseBLL.modifyHouseNum(uid, hid, House_update.this);
    }

    //从用户表查出name和id
    private List<User> getUserList() {
        return userBLL.getUserIdAndName(House_update.this);
    }

    //从房间表查数据
//    private List<House> getHouseList() {
//        return houseBLL.getHouseMsg(House_update.this);
//    }
}
