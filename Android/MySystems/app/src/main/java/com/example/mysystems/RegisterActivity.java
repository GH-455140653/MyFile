package com.example.mysystems;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.AccountBLL;
import com.example.Model.Account;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    EditText account, password;
    CheckBox cb;
    AccountBLL accountBLL=new AccountBLL();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
    }

    private void init() {
        //公共控件获取
        account = findViewById(R.id.rgt_get_account);
        password = findViewById(R.id.rgt_get_password);
        cb = findViewById(R.id.rgt_cb_pwd);

        //页面设置
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());//默认密文


        //设置密码显示的监听
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "请先输入密码", Toast.LENGTH_SHORT).show();
                    cb.setChecked(false);//置空
                } else {
                    if (cb.isChecked()) {
                        password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//实现明文密码
                    } else {
                        password.setTransformationMethod(PasswordTransformationMethod.getInstance());//实现密文密码
                    }
                }
            }
        });
    }

    //实现注册，检验
    public void register(View view) {
        Intent intent = new Intent();
        String act = account.getText().toString();
        String pwd = password.getText().toString();
        if (act.equals("") || pwd.equals("")) {
            Toast.makeText(getApplicationContext(), "请输入账号和密码", Toast.LENGTH_SHORT).show();//文字悬浮显示
        } else {
            boolean flag = false;
            List<Account> list = memberList();
            for (Account account : list) {
                if (account.getAccount().equals(act)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                member_insert(act, pwd);
                intent.putExtra("return_act", act);
                intent.putExtra("return_pwd", pwd);
                Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();//文字悬浮显示
                setResult(0, intent);
                finish();
            } else {
                Toast.makeText(this, "用户名已存在", Toast.LENGTH_SHORT).show();
            }
        }
    }

//实现数据库插入成员
public void member_insert(String act, String pwd) {
    accountBLL.createAccount(act,pwd,RegisterActivity.this);
}


//从数据库查出指定数据
public List<Account> memberList() {
    return accountBLL.getAccountName(RegisterActivity.this);
}
}
