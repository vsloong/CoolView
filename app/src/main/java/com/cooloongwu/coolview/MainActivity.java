package com.cooloongwu.coolview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.cooloongwu.coolview.anim.Anim;
import com.cooloongwu.coolview.anim.actions.AnimAction;
import com.cooloongwu.coolview.anim.actions.MyAnimation;
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

        //testExpectAnim();
        testAnim();
        //testPicasso();
    }

    private void testExpectAnim() {
        new ExpectAnim().expect(img)
                .toBe(bottomOfParent())
                .toAnimation()
                .setDuration(1000)
                .start();
    }


    private void testAnim() {
        Anim.with(MyAnimation.getAnimation(0, 2000),
                AnimAction.Test2.getAnimation(0, 2000))
                .into(img)
                .start();

    }

    private void testPicasso() {
        Picasso.with(this)
                .load("hhh")
                .error(R.mipmap.avatar)
                .into(img);

    }

}
