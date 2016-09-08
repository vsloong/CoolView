package com.cooloongwu.coolview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        MoneyView moneyView = (MoneyView) findViewById(R.id.money_view);
        //double类型，可以是“.3”、“.223”、“11”、“11.”，注意小数点2位后会进行五舍六入
        moneyView.setMoney(11);
    }
}
