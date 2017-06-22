package com.cooloongwu.coolview.anim.actions;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by CooLoongWu on 2017-6-21 15:40.
 */

public class Test1Action {

    public static Animation animation(int repeatTimes, long duration) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, 100);
        translateAnimation.setDuration(duration);
        translateAnimation.setFillAfter(true);

        return translateAnimation;
    }
}
