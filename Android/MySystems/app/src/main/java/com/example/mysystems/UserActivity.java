package com.example.mysystems;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.UserBLL;
import com.example.Model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class UserActivity extends AppCompatActivity {
    EditText ed_search;
    ListView lv;
    FloatingActionButton flb;
    List<User> listUserName;
    static int id;
    UserBLL userBLL = new UserBLL();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        init();
    }

    @Override
    protected void onResume() {
        //实现页面刷新，解决添加完界面为刷新情况
        super.onResume();
        init();
    }

    private void init() {
        //控件获取
        ed_search = findViewById(R.id.user_search_ed);
        lv = findViewById(R.id.user_lv);
        flb = findViewById(R.id.user_add_fab);

        //获取用户信息
        iteratorList();

        //listView点击事件实现租客信息修改功能
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //将选中的租客的个人信息传到修改页面
                Intent intent = new Intent(UserActivity.this, User_update.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", listUserName.get(position).getName());
                bundle.putString("sex", listUserName.get(position).getSex());
                bundle.putString("tel", listUserName.get(position).getTel());
                bundle.putString("IdNum", listUserName.get(position).getIdNUm());
                bundle.putString("date", listUserName.get(position).getDate());
                bundle.putString("address", listUserName.get(position).getAddress());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //listView长按事件实现租客信息删除功能
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //用静态变量进入内部类获取id用于删除
                id = 0;

                //获取选中id
                List<User> userList = memberList();
                for (User user : userList) {
                    if (user.getName().equals(listUserName.get(i).getName())) {
                        id = user.getId();
                    }
                }

                //对话框提示显示
                AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(UserActivity.this);
                alertdialogbuilder.setMessage("您确认要删除选中租客吗？");
                alertdialogbuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //删除选中信息
                        User_delete(id);
                        ed_search.setText("");
                        iteratorList();
                    }
                });
                alertdialogbuilder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                final AlertDialog alertdialog1 = alertdialogbuilder.create();
                alertdialog1.show();
                return true;
            }
        });

        //输入框监听，实现输入即查功能
        ed_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //实现输入值监听
                String name = ed_search.getText().toString();
                //用户数据获取
                iteratorList();

                if (name.equals("")) {
                    //无值时查询全部
                    iteratorList();
                } else {
                    //遍历查找是否存在输入值
                    boolean flag = false;
                    for (User user : listUserName) {
                        //查出相关值写入listUserName中用于后续读出
                        if (user.getName().equals(name)) {
                            flag = true;
                            listUserName.clear();
                            listUserName.add(user);
                            break;
                        }
                    }
                    if (flag) {
                        //将匹配值输出
                        lv.setAdapter(new MyAdapter());
                    } else {
                        //无匹配值置空listUserName
                        listUserName.clear();
                        lv.setAdapter(new MyAdapter());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listUserName.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView tv;

            //实现view的复用
            if (view != null) {
                tv = (TextView) view;
            } else {
                tv = new TextView(UserActivity.this);
            }
            tv.setText(listUserName.get(i).toString() + "\n");
            tv.setTextColor(Color.BLUE);
            tv.setTextSize(20);
            return tv;
        }
    }

    public void add(View v) {
        //实现页面跳转，进入添加界面
        Intent intent = new Intent(UserActivity.this, User_add.class);
        startActivity(intent);
    }

    public void click(View v) {
        String name = ed_search.getText().toString();

        //遍历查找是否存在输入值
        boolean flag = false;
        for (User user : listUserName) {
            if (user.getName().equals(name)) {
                flag = true;
                listUserName.clear();
                listUserName.add(user);
                break;
            }
        }
        if (name.equals("")) {
            Toast.makeText(this, "请输入租客姓名！", Toast.LENGTH_SHORT).show();
        } else {
            if (!flag) {
                Toast.makeText(this, "该用户不存在！", Toast.LENGTH_SHORT).show();
                Selection.selectAll(ed_search.getText());
            } else {
                lv.setAdapter(new MyAdapter());
                Selection.selectAll(ed_search.getText());
            }
        }
    }

    //从数据库查出指定数据
    private List<User> memberList() {
        return userBLL.getUser(UserActivity.this);
    }

    private void iteratorList() {
        listUserName = memberList();
        lv.setAdapter(new MyAdapter());
    }

    private void User_delete(int id) {
        userBLL.deleteUser(id, UserActivity.this);
    }

}
