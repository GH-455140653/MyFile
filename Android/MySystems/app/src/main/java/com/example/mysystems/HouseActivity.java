package com.example.mysystems;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.HouseBLL;
import com.example.Model.House;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HouseActivity extends AppCompatActivity {
    EditText ed_search;
    ListView lv;
    List<House> houseList;
    FloatingActionButton flb;
    HouseBLL houseBLL = new HouseBLL();
    static int Hid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house);

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
        ed_search = findViewById(R.id.house_search_ed);
        lv = findViewById(R.id.house_lv);
        flb = findViewById(R.id.house_add_fab);

        //数据初始化
        iteratorList();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //将选中的租客的个人信息传到修改页面
                Intent intent = new Intent(HouseActivity.this, House_update.class);
                Bundle bundle = new Bundle();
                bundle.putString("Hid", String.valueOf(houseList.get(i).getHid()));
                bundle.putString("Size", houseList.get(i).getSize());
                bundle.putString("name", houseList.get(i).getUserName());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //用静态变量进入内部类获取id用于删除
                Hid = 0;

                //获取选中id
                List<House> houseList = getCustomerList();
                for (House house : houseList) {
                    if (house.getHid() == (houseList.get(i).getHid())) {
                        Hid = house.getHid();
                    }
                }

                //对话框提示显示
                AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(HouseActivity.this);
                alertdialogbuilder.setMessage("您确认要删除选中房间吗？");
                alertdialogbuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //删除选中信息
                        delete(Hid);
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

        ed_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = ed_search.getText().toString();
                iteratorList();
                if (text.equals("")) {
                    //无值时查询全部
                    iteratorList();
                } else {
                    //遍历查找是否存在输入值
                    boolean flag = false;
                    for (House house : houseList) {
                        if (house.getHid() == Integer.parseInt(text)) {
                            flag = true;
                            houseList.clear();
                            houseList.add(house);
                            break;
                        }
                    }
                    if (flag) {
                        //将匹配值输出
                        lv.setAdapter(new MyAdapter());
                    } else {
                        houseList.clear();
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
            return houseList.size();
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
                tv = new TextView(HouseActivity.this);
            }
            tv.setText(houseList.get(i).customerString());
            tv.setTextColor(Color.BLUE);
            tv.setTextSize(20);
            return tv;
        }
    }

    public void query(View view) {
        //实现页面跳转，进入添加界面
        Intent intent = new Intent(HouseActivity.this, House_add.class);
        startActivity(intent);
    }

    private void delete(int hid) {
        houseBLL.deleteHouse(hid, HouseActivity.this);
    }

    private List<House> getCustomerList() {
        return houseBLL.getCustomerList(HouseActivity.this);
    }

    private void iteratorList() {
        houseList = getCustomerList();
        lv.setAdapter(new MyAdapter());
    }
}
