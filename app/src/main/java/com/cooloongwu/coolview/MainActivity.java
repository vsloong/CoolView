package com.cooloongwu.coolview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.ImageView;

import com.github.florent37.expectanim.ExpectAnim;

import static com.github.florent37.expectanim.core.Expectations.outOfScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        ImageView img = (ImageView) findViewById(R.id.img);

        new ExpectAnim().expect(img)
                .toBe(outOfScreen(Gravity.BOTTOM))
                .toAnimation()
                .setDuration(2000)
                .start();

    }


}
