package com.example.mysystems;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.UserBLL;
import com.example.Model.User;
import com.example.Util.RegexBase;

import java.util.Calendar;
import java.util.List;

public class User_update extends AppCompatActivity {
    EditText name, address, tel, idNum, date;
    RadioButton rb_men, rb_women;
    ImageView imageView;
    Button btn;
    Intent intent;
    UserBLL userBLL = new UserBLL();
    RegexBase regexBase = new RegexBase();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_query);
        init();
    }

    private void init() {

        //控件获取
        String sex = "";
        name = findViewById(R.id.user_add_username_ed);
        address = findViewById(R.id.user_add_userAddress_ed);
        tel = findViewById(R.id.user_add_userTel_ed);
        idNum = findViewById(R.id.user_add_userIdNum_ed);
        date = findViewById(R.id.user_add_userDate_ed);
        rb_men = findViewById(R.id.user_add_man_rb);
        rb_women = findViewById(R.id.user_add_woman_rb);
        btn = findViewById(R.id.user_query_btn);
        imageView = findViewById(R.id.user_query_iv);
        intent = getIntent();
        Bundle bundle = intent.getExtras();

        //控件参数初始化
        btn.setText("修改");
        imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.user_update_font));
        name.setText(bundle.getString("name"));
        address.setText(bundle.getString("address"));
        tel.setText(bundle.getString("tel"));
        idNum.setText(bundle.getString("IdNum"));
        date.setText(bundle.getString("date"));
        sex = bundle.getString("sex");
        if (sex.equals("男")) {
            rb_men.setChecked(true);
        } else {
            rb_women.setChecked(true);
        }


        //日期对话框实现
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //日历选择时间
                Calendar c = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog(User_update.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        //隐藏键盘
                        InputMethodManager imm = (InputMethodManager) User_update.this.getSystemService(Context.INPUT_METHOD_SERVICE);
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
        //数据获取
        int id = 0;
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

        //遍历查找指定的id值
        List<User> userList = UserList();
        for (User user : userList) {
            if (user.getName().equals(name_ed)) {
                id = user.getId();
                break;
            }
        }

        //逻辑判断
        if (name_ed.equals("") || tel_ed.equals("") || address_ed.equals("") || idNum_ed.equals("") || date_ed.equals("")) {
            Toast.makeText(this, "请完整输入租客信息!", Toast.LENGTH_SHORT).show();
        }
        if (!regexBase.isTelPhoneNumber(tel_ed)) {
            Toast.makeText(this, "该手机号无效！", Toast.LENGTH_SHORT).show();
        } else if (!regexBase.isIdNumber(idNum_ed)) {
            Toast.makeText(this, "身份证不合法！", Toast.LENGTH_SHORT).show();
        } else {
            update(name_ed, tel_ed, address_ed, idNum_ed, date_ed, sex_rb, id);
            Toast.makeText(this, "用户修改成功！", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    public void update(String name_ed, String tel_ed, String address_ed, String idNum_ed, String date_ed, String sex, int id) {
        userBLL.modifyUserMsg(name_ed, tel_ed, address_ed, idNum_ed, date_ed, sex, id, User_update.this);
    }

    //从数据库查出指定数据
    private List<User> UserList() {
        return userBLL.getUserIdAndName(User_update.this);
    }
}
