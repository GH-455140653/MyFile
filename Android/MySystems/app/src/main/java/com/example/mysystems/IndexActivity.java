package com.example.mysystems;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Util.ActivityFinishUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexActivity extends AppCompatActivity {
    ListView lv;
    TextView tv;
    static String account;
    static boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        ActivityFinishUtil.addActivity(this);

        init();
    }

    protected void init() {
        tv = findViewById(R.id.index_title);
        tv_init();//标题初始化

        lv = findViewById(R.id.index_lv);
        lv_init();//lv初始化

        //lv点击事件实现页面跳转
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    setActivity(IndexActivity.this, AccountActivity.class);
                } else if (position == 1) {
                    setActivity(IndexActivity.this, UserActivity.class);
                } else if (position == 2) {
                    setActivity(IndexActivity.this, HouseActivity.class);
                } else if (position == 3) {
                    setActivity(IndexActivity.this, FinanceActivity.class);
                } else {
                    ActivityFinishUtil.finishAllActivity();
                }
            }
        });
    }

    private void tv_init() {
        //多个静态变量控制不同界面的回传数据
        Intent intent = getIntent();
        flag = intent.getBooleanExtra("flag", false);
        if (!flag) {
            if (account != null) {
                //处理从子界面返回的空值问题
                tv.setText(account + ",欢迎使用出租房客管理系统");
            } else {
                //处理登录完第一次用户名传值问题
                account = intent.getStringExtra("account");
                tv.setText(account + ",欢迎使用出租房客管理系统");
            }
        } else {
            //处理改完用户信息时静态变量有值不刷新问题
            account = intent.getStringExtra("account");
            tv.setText(account + ",欢迎使用出租房客管理系统");
        }
    }

    //通过simpleAdapter实现listView的图文显示
private void lv_init() {
    int[] imageId = {R.drawable.account, R.drawable.user, R.drawable.house, R.drawable.financial, R.drawable.out};
    String[] list_name = {"用户中心", "租客信息", "房屋管理", "财务管理", "退出系统"};

    List<Map<String, Object>> data = new ArrayList<>();
    for (int i = 0; i < list_name.length; i++) {
        Map<String, Object> map = new HashMap<>();
        map.put("photo", imageId[i]);
        map.put("name", list_name[i]);
        data.add(map);
    }
    SimpleAdapter simpleAdapter = new SimpleAdapter(IndexActivity.this, data, R.layout.index_simple, new String[]{"photo", "name"}, new int[]{R.id.index_smp_photo, R.id.index_smp_text});
    lv.setAdapter(simpleAdapter);
}

    //页面跳转
    private void setActivity(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        intent.putExtra("account", account);
        startActivity(intent);
    }
}
