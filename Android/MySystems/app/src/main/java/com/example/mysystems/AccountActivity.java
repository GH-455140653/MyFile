package com.example.mysystems;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.AccountBLL;
import com.example.Model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {
    String admin;
    EditText account, password, pwd_sure;
    Switch pwd_switch, pwd_sure_switch;
    AccountBLL accountBLL = new AccountBLL();
    SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }

    private void init() {
        //控件获取
        account = findViewById(R.id.account_account);
        password = findViewById(R.id.account_password);
        pwd_sure = findViewById(R.id.account_pwdSure);

        sp = this.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        //明文/密文显示控件点击事件
        pwd_switch = findViewById(R.id.account_pwd_switch);
        pwd_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "请先输入密码", Toast.LENGTH_SHORT).show();
                    pwd_switch.setChecked(false);//置空
                } else {
                    if (pwd_switch.isChecked()) {
                        password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//实现明文密码
                    } else {
                        password.setTransformationMethod(PasswordTransformationMethod.getInstance());//实现密文密码
                    }
                }
            }
        });

        pwd_sure_switch = findViewById(R.id.account_pwdSure_switch);
        pwd_sure_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pwd_sure.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "请先输入二次密码", Toast.LENGTH_SHORT).show();
                    pwd_sure_switch.setChecked(false);//置空
                } else {
                    if (pwd_sure_switch.isChecked()) {
                        pwd_sure.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//实现明文密码
                    } else {
                        pwd_sure.setTransformationMethod(PasswordTransformationMethod.getInstance());//实现密文密码
                    }
                }
            }
        });

        //接收数据
        Intent intent = getIntent();
        admin = intent.getStringExtra("account");

        account.setText(admin);
    }

    public void modify(View v) {
        String act = account.getText().toString();
        String pwd = password.getText().toString();
        String pwdSure = pwd_sure.getText().toString();
        int id = 0;

        //查出目前用户的id
        List<Account> accountList = memberList();
        List<String> nameList = new ArrayList<>();
        for (Account account : accountList) {
            nameList.add(account.getAccount());
            if (account.getAccount().equals(admin)) {
                id = account.getId();
                break;
            }
        }

        //update的逻辑判断
        if (act.equals("")) {
            Toast.makeText(this, "用户名未填写！", Toast.LENGTH_SHORT).show();
        } else if (pwd.equals("")) {
            Toast.makeText(this, "密码未填写！", Toast.LENGTH_SHORT).show();
        } else if (pwdSure.equals("")) {
            Toast.makeText(this, "确认密码框未填写！", Toast.LENGTH_SHORT).show();
        } else {
            if (!pwd.equals(pwdSure)) {
                Toast.makeText(this, "两次密码输入不一致\n请重新输入！", Toast.LENGTH_SHORT).show();
            } else if (isExitsName(nameList, act)) {
                Toast.makeText(this, "你修改的用户名已存在！", Toast.LENGTH_SHORT).show();
            } else {
                member_update(act, pwd, id);
                Toast.makeText(this, "个人信息修改成功\n请重新登录~", Toast.LENGTH_SHORT).show();
                admin = act;
                clear_pwd();
                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//实现singleTask启动登录界面，解决重启登录界面各种界面初始化问题
                startActivity(intent);
            }
        }
    }

    //实现数据库修改成员信息
    private void member_update(String act, String pwd, int id) {
        accountBLL.modifyAccount(act, pwd, id, AccountActivity.this);
    }

    //从数据库查出指定数据
    private List<Account> memberList() {
        return accountBLL.getAccountIdAndName(AccountActivity.this);
    }

    //已有的名字判断
    private boolean isExitsName(List<String> list, String act) {
        boolean flag = false;
        for (String items : list) {
            if (items.equals(act)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //SharedPreferences清除数据
    private void clear_pwd() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Account", admin);
        editor.putString("Password", "");
        editor.putBoolean("flag", false);
        editor.apply();
    }
}
