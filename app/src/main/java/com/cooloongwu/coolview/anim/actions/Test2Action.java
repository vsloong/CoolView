package com.cooloongwu.coolview.anim.actions;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * Created by CooLoongWu on 2017-6-21 15:40.
 */

public class Test2Action {

    public static Animation animation(int repeatTimes, long duration) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, //0.5 = 1/2的自己父控件的长度
                Animation.RELATIVE_TO_SELF, 0.5f);//0.5 = 1/2的自己的长度
        rotateAnimation.setRepeatCount(repeatTimes);
        rotateAnimation.setDuration(duration);

        return rotateAnimation;
    }
}
