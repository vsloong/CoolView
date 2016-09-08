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
        moneyView.setMoney(200.23);
    }
}
