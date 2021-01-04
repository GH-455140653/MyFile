package com.example.mysystems;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.BLL.AccountBLL;
import com.example.Util.ActivityFinishUtil;
import com.example.Model.Account;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText account;
    EditText password;
    CheckBox cb_pwd_show, cb_pwd_rmb;
    SharedPreferences sp;
    AccountBLL accountBLL = new AccountBLL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ActivityFinishUtil.addActivity(this);

        init();
    }

    private void init() {
        //公共控件获取与初始化
        account = findViewById(R.id.get_account);
        password = findViewById(R.id.get_password);
//        password.setTransformationMethod(PasswordTransformationMethod.getInstance());//默认密文
        cb_pwd_show = findViewById(R.id.cb_pwd_show);
        cb_pwd_rmb = findViewById(R.id.login_rmb_cb);
        sp = this.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        show();

        //输入框判空与记住密码复选框监测
        cb_pwd_rmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String act = account.getText().toString();
                String pwd = password.getText().toString();
                if (act.equals("") || pwd.equals("")) {
                    Toast.makeText(getApplicationContext(), "请先输入账号和密码", Toast.LENGTH_SHORT).show();//文字悬浮显示
                    cb_pwd_rmb.setChecked(false);
                }
            }
        });

        //设置密码显示的监听
        cb_pwd_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "请先输入密码", Toast.LENGTH_SHORT).show();
                    cb_pwd_show.setChecked(false);//置空
                } else {
                    if (cb_pwd_show.isChecked()) {
                        password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//实现明文密码
                    } else {
                        password.setTransformationMethod(PasswordTransformationMethod.getInstance());//实现密文密码
                    }
                }
            }
        });

        //实现按钮超链接
        Button btn_bug = findViewById(R.id.btn_bug);
        btn_bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://lrl-home.online/");    //设置跳转的网站
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //实现判空、验证与页面跳转
        Button btn_submit = findViewById(R.id.login_btn);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//匿名函数按钮事件
                String act = account.getText().toString();
                String pwd = password.getText().toString();
                List<Account> list = memberList();

                //判空
                if (act.equals("") || pwd.equals("")) {
                    Toast.makeText(getApplicationContext(), "请输入账号和密码", Toast.LENGTH_SHORT).show();//文字悬浮显示
                } else {
                    //验证
                    boolean ACT_flag = false;
                    for (Account account : list) {
                        if (account.getAccount().equals(act)) {
                            ACT_flag = true;
                            break;
                        }
                    }
                    if (ACT_flag) {
                        boolean PWD_flag = false;
                        for (Account password : list) {
                            if (password.getPassword().equals(pwd)) {
                                PWD_flag = true;
                                break;
                            }
                        }
                        if (PWD_flag) {
                            //跳转
                            Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                            //记住密码
                            if (cb_pwd_rmb.isChecked()) {
                                remember(act, pwd);
                            } else {
                                clear();
                            }
                            //数据传递
                            Intent intent = new Intent(LoginActivity.this, IndexActivity.class);
                            intent.putExtra("account", act);//传送账号
                            intent.putExtra("flag", true);//标识变量
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "用户名不存在！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //SharedPreferences记录数据
    protected void remember(String act, String pwd) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Account", act);
        editor.putString("Password", pwd);
        editor.putBoolean("flag", true);
        editor.apply();
    }

    //SharedPreferences清除数据
    protected void clear() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Account", "");
        editor.putString("Password", "");
        editor.putBoolean("flag", false);
        editor.apply();
    }

    //SharedPreferences显示数据
    protected void show() {
        sp = this.getSharedPreferences("UserInfo", MODE_PRIVATE);
        String act = sp.getString("Account", "");
        String pwd = sp.getString("Password", "");
        account.setText(act);
        password.setText(pwd);
        if (sp.getBoolean("flag", false)) {
            cb_pwd_rmb.setChecked(true);
        }
    }

    //从数据库中获取指定的数据用于检验登录
    protected List<Account> memberList() {
        return accountBLL.getAccountAll(LoginActivity.this);
    }

    //注册按钮事件，实现页面跳转
    public void register(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, 0);
    }

    //实现数据回传
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //判断解决回传时无数据问题
        if (data != null) {
            super.onActivityResult(requestCode, resultCode, data);
            String act = data.getStringExtra("return_act");
            String pwd = data.getStringExtra("return_pwd");
            account.setText(act);
            password.setText(pwd);
        }
    }
}