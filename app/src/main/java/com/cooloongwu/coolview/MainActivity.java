package com.cooloongwu.coolview;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import com.cooloongwu.coolview.anim.Anim;
import com.cooloongwu.coolview.anim.MyAnimator;
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

        ImageView imgBtn = (ImageView) findViewById(R.id.imgBtn);
        Drawable drawable = imgBtn.getDrawable();
        ((Animatable) drawable).start();

//        TestView view = (TestView) findViewById(R.id.test);
//
//        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "fraction", 0, 500, 200);
//        anim.setDuration(2000);
//        anim.start();

        //testExpectAnim();
        //testAnim();
        //testPicasso();
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext();
            }
        });


        MyAnimator.animate(img)
                .rotation(0, 500, 200)
                .start();

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

    private void goNext() {
        //View img = (ImageView) findViewById(R.id.img);

        View textView = findViewById(R.id.text);
        Intent intent = new Intent(this, NextActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                    Pair.create((View) img, "img"),
                    Pair.create(textView, "text"))
                    .toBundle());
        }
    }

}
