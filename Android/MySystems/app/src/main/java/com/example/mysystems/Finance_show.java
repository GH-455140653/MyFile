package com.example.mysystems;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.FinanceBLL;
import com.example.Util.SQLHelper;

import java.util.List;

public class Finance_show extends AppCompatActivity {
    ListView lv;
    List<String> financeItemsList;
    static String Hid, Uid, time;
    FinanceBLL financeBLL = new FinanceBLL();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance_show);

        init();
    }

    private void init() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Hid = bundle.getString("Hid");
        Uid = bundle.getString("Uid");
        time = bundle.getString("date");

        financeItemsList = getItemsList(Hid, Uid, time);

        lv = findViewById(R.id.finance_show_lv);
        lv.setAdapter(new MyAdapter());

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 2) {
                    //对话框提示显示用电详细信息
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Finance_show.this);
                    alertdialogbuilder.setItems(getEleMsg(Hid, Uid, time), null);
                    alertdialogbuilder.setTitle("电费详情：");
                    alertdialogbuilder.setPositiveButton("确定", null);

                    final AlertDialog alertdialog = alertdialogbuilder.create();
                    alertdialog.show();
                }
                if (i == 3) {
                    //对话框提示显示用水详细信息
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Finance_show.this);
                    alertdialogbuilder.setItems(getWatMsg(Hid, Uid, time), null);
                    alertdialogbuilder.setTitle("水费详情：");
                    alertdialogbuilder.setPositiveButton("确定", null);

                    final AlertDialog alertdialog = alertdialogbuilder.create();
                    alertdialog.show();
                }
            }
        });
    }

    private String[] getEleMsg(String hid, String uid, String time) {
        return financeBLL.getEandW_electricity(hid, uid, time, Finance_show.this);
    }

    private String[] getWatMsg(String hid, String uid, String time) {
        return financeBLL.getEandW_waterMsg(hid, uid, time, Finance_show.this);
    }

    private List<String> getItemsList(String hid, String uid, String time) {
        return financeBLL.getFinanceItemsList(hid, uid, time, Finance_show.this);
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return financeItemsList.size();
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
            String[] nameList = {"月份:", "房号:", "电费:", "水费:", "房租:", "网费:", "合计:"};
            TextView tv;

            //实现view的复用
            if (view != null) {
                tv = (TextView) view;
            } else {
                tv = new TextView(Finance_show.this);
            }
            tv.setText(nameList[i] + financeItemsList.get(i));
            tv.setTextColor(Color.BLUE);
            tv.setTextSize(30);
            return tv;
        }
    }
}
