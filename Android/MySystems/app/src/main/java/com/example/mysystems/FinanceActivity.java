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

import com.example.BLL.FinanceBLL;
import com.example.Model.Finance;
import com.example.Util.SQLHelper;

import java.util.List;

public class FinanceActivity extends AppCompatActivity {
    ListView lv;
    SQLHelper helper;
    EditText ed_search;
    List<Finance> financeList;
    FinanceBLL financeBLL = new FinanceBLL();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance);

        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    public void add(View view) {
        Intent intent = new Intent(FinanceActivity.this, Finance_add.class);
        startActivity(intent);
    }

    private void init() {
        helper = new SQLHelper(this);

        //控件获取
        ed_search = findViewById(R.id.finance_search_ed);

        //数据初始化
        financeList = getFinanceMsg();

        //ListView相关
        lv = findViewById(R.id.finance_lv);
        lv.setAdapter(new MyAdapter());

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
                    //查出指定数据行
                    financeList = getFinanceMsgByHid(text);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FinanceActivity.this, Finance_show.class);
                Bundle bundle = new Bundle();
                bundle.putString("Uid", String.valueOf(financeList.get(i).getUid()));
                bundle.putString("Hid", String.valueOf(financeList.get(i).getHid()));
                bundle.putString("date", financeList.get(i).getDate());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String Uid = String.valueOf(financeList.get(i).getUid());
                final String Hid = String.valueOf(financeList.get(i).getHid());
                final String time = String.valueOf(financeList.get(i).getDate());

                //对话框提示显示
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FinanceActivity.this);
                alertDialogBuilder.setMessage("您确认要删除选中的报表吗？");
                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //删除选中信息
                        delete(Hid, Uid, time);
                        ed_search.setText("");
                        iteratorList();
                    }
                });
                alertDialogBuilder.setNeutralButton("取消", null);

                final AlertDialog alertdialog = alertDialogBuilder.create();
                alertdialog.show();

                return true;
            }
        });
    }

    private List<Finance> getFinanceMsgByHid(String hid) {
        return financeBLL.getFinanceMsgByHid(hid, FinanceActivity.this);
    }

    private void delete(String hid, String uid, String time) {
        financeBLL.deleteFinanceMsg(hid, uid, time, FinanceActivity.this);
    }

    private List<Finance> getFinanceMsg() {
        return financeBLL.getFinanceMsg(FinanceActivity.this);
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return financeList.size();
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
                tv = new TextView(FinanceActivity.this);
            }
            tv.setText("时间:" + financeList.get(i).getDate() + "\n房号：" + financeList.get(i).getHid() + "\n姓名:" + financeList.get(i).getUserName());
            tv.setTextColor(Color.BLUE);
            tv.setTextSize(20);
            return tv;
        }
    }

    private void iteratorList() {
        financeList = getFinanceMsg();
        lv.setAdapter(new MyAdapter());
    }
}
