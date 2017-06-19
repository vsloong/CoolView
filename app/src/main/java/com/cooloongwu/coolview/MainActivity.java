package com.cooloongwu.coolview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.cooloongwu.coolview.anim.Anim;
import com.github.florent37.expectanim.ExpectAnim;
import com.squareup.picasso.Picasso;

import static com.github.florent37.expectanim.core.Expectations.bottomOfParent;

public class MainActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);

        initViews();

        test();
    }

    private void initViews() {
        new ExpectAnim().expect(img)
                .toBe(bottomOfParent())
                .toAnimation()
                .setDuration(2000)
                .start();
    }


    private void test() {
        Anim.Builder.into(img)
                .build()
                .showSomething();

        Picasso.with(this)
                .load("hhh")
                .into(img);
    }

}
