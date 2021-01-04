package com.example.mysystems;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.HouseBLL;
import com.example.Model.House;
import com.example.Util.RegexBase;

import java.util.List;

public class House_add extends AppCompatActivity {
    EditText ed_houseNum, ed_houseSize;
    HouseBLL houseBLL = new HouseBLL();
    RegexBase regexBase = new RegexBase();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_add);
        init();
    }

    private void init() {
        //控件获取
        ed_houseNum = findViewById(R.id.house_add_houseNum_ed);
        ed_houseSize = findViewById(R.id.house_add_houseSize_ed);
    }

    public void add(View view) {
        //控件数据获取
        String houseNum = ed_houseNum.getText().toString();
        String houseSize = ed_houseSize.getText().toString();
        List<House> houseNumList = getHouseNumList();

        if (houseNum.equals("") || houseSize.equals("")) {
            Toast.makeText(this, "请完整填写房间信息！", Toast.LENGTH_SHORT).show();
        } else {
            boolean flag = false;
            for (House house : houseNumList) {
                if (house.getHid() == Integer.parseInt(houseNum)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                Toast.makeText(this, "该房号已存在！", Toast.LENGTH_SHORT).show();
            } else {
                if (regexBase.isNumber(houseNum)) {
                    house_insert(houseNum, houseSize);
                    Toast.makeText(this, "房间信息添加成功！", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "房间号必须为纯数字！", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void house_insert(String Hid, String HSize) {
        houseBLL.createHouse(Hid, HSize, House_add.this);
    }

    //从房间表查出房号列表
    private List<House> getHouseNumList() {
        return houseBLL.getHouseId(House_add.this);
    }
}
