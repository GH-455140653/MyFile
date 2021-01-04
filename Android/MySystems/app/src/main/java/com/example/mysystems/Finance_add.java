package com.example.mysystems;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BLL.FinanceBLL;
import com.example.Model.Finance;
import com.example.Model.House;
import com.example.Model.User;
import com.example.Util.SQLHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Finance_add extends AppCompatActivity {
    Spinner sp_houseNum, sp_userName;
    EditText ed_date, ed_preWat, ed_preEle, ed_nowWat, ed_nowEle, ed_netRant, ed_houseRant;
    FinanceBLL financeBLL = new FinanceBLL();

    float min_now_preEle = 0;
    float min_now_preWat = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance_add);

        init();
    }

    private void init() {
        //控件获取
        sp_houseNum = findViewById(R.id.finance_add_houseNum_sp);
        sp_userName = findViewById(R.id.finance_add_userName_sp);
        ed_date = findViewById(R.id.finance_add_date_ed);
        ed_preEle = findViewById(R.id.finance_add_preEle_ed);
        ed_preWat = findViewById(R.id.finance_add_preWat_ed);
        ed_nowEle = findViewById(R.id.finance_add_nowEle_ed);
        ed_nowWat = findViewById(R.id.finance_add_nowWat_ed);
        ed_houseRant = findViewById(R.id.finance_add_houseRant_ed);
        ed_netRant = findViewById(R.id.finance_add_netRant_ed);

        //控件初始化
        initHouseNumSpinner();
        initDate();

        ed_date.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ed_houseRant.setText("");
                ed_netRant.setText("");
                ed_preWat.setText("");
                ed_preEle.setText("");
                ed_nowWat.setText("");
                ed_nowEle.setText("");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String hid = sp_houseNum.getSelectedItem().toString();
                String username = sp_userName.getSelectedItem().toString();
                String date = ed_date.getText().toString();
                date = getYandM(date);
                String lastdate = getLastdate(date);

                List<Finance> financeList = financeBLL.getAddMsgBefore(username, hid, lastdate, Finance_add.this);

                if (financeList.size() != 0) {
                    min_now_preEle = financeList.get(0).getNowEle();
                    min_now_preWat = financeList.get(0).getNowWat();

                    ed_houseRant.setText(String.valueOf(financeList.get(0).getHouseRant()));
                    ed_netRant.setText(String.valueOf(financeList.get(0).getNetRant()));
                    ed_preWat.setText(String.valueOf(financeList.get(0).getPreWat()));
                    ed_preEle.setText(String.valueOf(financeList.get(0).getPreEle()));
                    ed_nowEle.setHint("请输入大于等于" + min_now_preEle + "的数字");
                    ed_nowWat.setHint("请输入大于等于" + min_now_preWat + "的数字");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    public void add(View view) {
        if (sp_userName.getCount() == 0 || sp_userName.getCount() == 0 || ed_date.getText().toString().equals("")
                || ed_houseRant.getText().toString().equals("") || ed_netRant.getText().toString().equals("")
                || ed_nowWat.getText().toString().equals("") || ed_nowEle.getText().toString().equals("")
                || ed_preWat.getText().toString().equals("") || ed_preEle.getText().toString().equals("")) {
            Toast.makeText(this, "请完整填写报表信息！", Toast.LENGTH_SHORT).show();
        } else {
            List<User> userList = getUserList();
            String houseNum = sp_houseNum.getSelectedItem().toString();
            String userName = sp_userName.getSelectedItem().toString();
            String date = ed_date.getText().toString();
            float netRant = Float.parseFloat(ed_netRant.getText().toString());
            float houseRant = Float.parseFloat(ed_houseRant.getText().toString());
            float preEle = Float.parseFloat(ed_preEle.getText().toString());
            float preWat = Float.parseFloat(ed_preWat.getText().toString());
            float nowEle = Float.parseFloat(ed_nowEle.getText().toString());
            float nowWat = Float.parseFloat(ed_nowWat.getText().toString());

            String userId = "0";
            float lastEle = 0;
            float lastWat = 0;
            float Ele;
            float Wat;
            float Ele_money;
            float Wat_money;
            float summary;

            //日期的年月获取(需修改，影响效率)
            date = getYandM(date);

            //获取Uid
            for (User user : userList) {
                if (userName.equals(user.getName())) {
                    userId = String.valueOf(user.getId());
                }
            }

            //获取上个月实用水电
            List<Finance> financeList = EandW_get(houseNum, userId);
            String lastDate = "";//
            if (financeList.size() == 0) {
                lastEle = 0;
                lastWat = 0;
            } else {
                //获取上个月的年月
                lastDate = getLastdate(date);
                for (Finance finance : financeList) {
                    //匹配上个月的水电数据
                    if (lastDate.equals(finance.getDate())) {
                        lastEle = finance.getNowEle();
                        lastWat = finance.getNowWat();
                    }
                }
            }

            //计算当月实用水电
            Ele = nowEle - lastEle;
            Wat = nowWat - lastWat;


            //计算当月水电费
            Ele_money = preEle * Ele;
            Wat_money = preWat * Wat;

            //计算该月总费用
            summary = Ele_money + Wat_money + netRant + houseRant;


            if (getDateInTable(houseNum, userName, date)) {
                Toast.makeText(this, "你填写的时间在报表中已存在！！！\n请重新填写报表时间", Toast.LENGTH_SHORT).show();
            } else if (nowEle < min_now_preEle) {
                Toast.makeText(this, "该月电度比上月小！\n上月电度为：" + min_now_preEle, Toast.LENGTH_SHORT).show();
                ed_nowEle.requestFocus();
            } else if (nowWat < min_now_preWat) {
                Toast.makeText(this, "该月水方比上月小！\n上月水方为：" + min_now_preWat, Toast.LENGTH_SHORT).show();
                ed_nowEle.requestFocus();
            } else {
                //写入数据库存储
                EandW_add(houseNum, userId, date, preWat, preEle, nowEle, nowWat, Ele, Wat, lastEle, lastWat);
                finance_add(houseNum, userId, date, Ele_money, Wat_money, netRant, houseRant, summary);
                finish();
            }
        }
    }

    private boolean getDateInTable(String hid, String username, String date) {
        return financeBLL.getFianceDate(hid, username, date, Finance_add.this);
    }

    private List<Finance> EandW_get(String houseNum, String userId) {
        return financeBLL.getEandWMsg(houseNum, userId, Finance_add.this);
    }

    private String getYandM(String date) {
        String YandM = "";
        String month = "";
        String year = "";

        String[] date_temp = date.split("-");
        for (int i = 0; i < date_temp.length; i++) {
            if (i == 0) {
                year = date_temp[i];
            }
            if (i == 1) {
                month = date_temp[i];
            }
        }
        YandM = year + "-" + month;
        return YandM;
    }

    private String getLastdate(String date) {
        String lastdate = "";
        String month = "";
        String year = "";
        String[] date_temp = date.split("-");
        for (int i = 0; i < date_temp.length; i++) {
            if (i == 0) {
                year = date_temp[i];
            }
            if (i == 1) {
                if (date_temp[i].equals("1")) {
                    month = "12";
                    year = String.valueOf(Integer.parseInt(year) - 1);
                } else {
                    month = date_temp[i];
                    month = String.valueOf(Integer.parseInt(month) - 1);
                }
            }
        }

        lastdate = year + "-" + month;
        return lastdate;
    }

    private void EandW_add(String Hid, String Uid, String date, float preWat, float preEle, float nowEle, float nowWat, float Ele, float Wat, float lastEle, float lastWat) {
        financeBLL.EandWAdd(Hid, Uid, date, preEle, preWat, nowEle, nowWat, Ele, Wat, lastEle, lastWat, Finance_add.this);
    }

    private void finance_add(String Hid, String Uid, String time, float Electricity, float Water, float netRant, float houseRant, float summary) {
        financeBLL.financeAdd(Hid, Uid, time, Electricity, Water, netRant, houseRant, summary, Finance_add.this);
    }

    private void initDate() {
        ed_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //日历选择时间
                Calendar c = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog(Finance_add.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        //隐藏键盘
                        InputMethodManager imm = (InputMethodManager) Finance_add.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(ed_date.getWindowToken(), 0);
                        String st;
                        month = month + 1;
                        st = year + "-" + month + "-" + day;
                        ed_date.setText(st);
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });
    }

    private void initUserNameSpinner(List<String> userNameList) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Finance_add.this, android.R.layout.simple_spinner_item, userNameList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_userName.setAdapter(adapter);
        sp_userName.setVisibility(View.VISIBLE);
    }

    private void initHouseNumSpinner() {
        final List<House> houseMsgList = getHouseList();
        List<String> houseNumList = new ArrayList<>();
        final List<String> userNameList = new ArrayList<>();

        houseNumList.add("请选择房间号");
        for (House house : houseMsgList) {
            houseNumList.add(String.valueOf(house.getHid()));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Finance_add.this, android.R.layout.simple_spinner_item, houseNumList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_houseNum.setAdapter(adapter);
        sp_houseNum.setVisibility(View.VISIBLE);

        sp_houseNum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean ifFirst = true;//实现第一次进入时不执行

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (ifFirst) {
                    ifFirst = false;
                } else {
                    if (sp_houseNum.getSelectedItemPosition() == 0) {
                        Toast.makeText(Finance_add.this, "请选择房间号！", Toast.LENGTH_SHORT).show();
                        userNameList.clear();
                        userNameList.add("请先选择房间号");
                    } else {
                        int hid = Integer.parseInt(sp_houseNum.getSelectedItem().toString());
                        for (House house : houseMsgList) {
                            if (house.getHid() == hid) {
                                userNameList.clear();
                                userNameList.add(String.valueOf(house.getUserName()));
                            }
                        }
                    }
                    initUserNameSpinner(userNameList);
                    ed_date.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private List<User> getUserList() {
        return financeBLL.getUserList(Finance_add.this);
    }

    private List<House> getHouseList() {
        return financeBLL.getHouseList(Finance_add.this);
    }
}
