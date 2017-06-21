package com.cooloongwu.coolview.anim.actions;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;

/**
 * Created by CooLoongWu on 2017-6-21 15:40.
 */

public class Test2Action {

    public static AnimationSet animationSet(int repeatTimes, long duration) {
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, //0.5 = 1/2的自己父控件的长度
                Animation.RELATIVE_TO_SELF, 0.5f);//0.5 = 1/2的自己的长度
        rotateAnimation.setRepeatCount(repeatTimes);
        rotateAnimation.setDuration(duration);

        animationSet.addAnimation(rotateAnimation);
        return animationSet;
    }
}
