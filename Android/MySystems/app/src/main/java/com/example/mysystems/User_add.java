package com.example.mysystems;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.UserBLL;
import com.example.Util.RegexBase;

import java.util.Calendar;

public class User_add extends AppCompatActivity {
    EditText name, address, tel, idNum, date;
    Button btn;
    RadioButton rb_men, rb_women;
    UserBLL userBLL = new UserBLL();
    RegexBase regexBase = new RegexBase();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_query);
        init();
    }

    private void init() {

        name = findViewById(R.id.user_add_username_ed);
        address = findViewById(R.id.user_add_userAddress_ed);
        tel = findViewById(R.id.user_add_userTel_ed);
        idNum = findViewById(R.id.user_add_userIdNum_ed);
        date = findViewById(R.id.user_add_userDate_ed);
        rb_men = findViewById(R.id.user_add_man_rb);
        rb_women = findViewById(R.id.user_add_woman_rb);
        btn = findViewById(R.id.user_query_btn);

        btn.setText("添加");


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //日历选择时间
                Calendar c = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog(User_add.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        //隐藏键盘
                        InputMethodManager imm = (InputMethodManager) User_add.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(date.getWindowToken(), 0);
                        String st;
                        month = month + 1;
                        st = year + "-" + month + "-" + day;
                        date.setText(st);
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
    }

    public void query(View view) {
        String name_ed = name.getText().toString();
        String tel_ed = tel.getText().toString();
        String address_ed = address.getText().toString();
        String idNum_ed = idNum.getText().toString();
        String date_ed = date.getText().toString();
        String sex_rb;
        if (rb_women.isChecked()) {
            sex_rb = rb_women.getText().toString();
        } else {
            sex_rb = rb_men.getText().toString();
        }
        if (name_ed.equals("") || tel_ed.equals("") || address_ed.equals("") || idNum_ed.equals("") || date_ed.equals("")) {
            Toast.makeText(this, "请完整输入租客信息!", Toast.LENGTH_SHORT).show();
        } else {
            if (!regexBase.isTelPhoneNumber(tel_ed)) {
                Toast.makeText(this, "该手机号无效！", Toast.LENGTH_SHORT).show();
            } else if (!regexBase.isIdNumber(idNum_ed)) {
                Toast.makeText(this, "身份证不合法！", Toast.LENGTH_SHORT).show();
            } else {
                user_insert(name_ed, tel_ed, address_ed, idNum_ed, date_ed, sex_rb);
                Toast.makeText(this, "用户添加成功！", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    //实现数据库插入成员
    public void user_insert(String name_ed, String tel_ed, String address_ed, String idNum_ed, String date_ed, String sex) {
        userBLL.createUser(name_ed, tel_ed, address_ed, idNum_ed, date_ed, sex, User_add.this);
    }
}