package com.cooloongwu.coolview.anim.actions;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

/**
 * Created by CooLoongWu on 2017-6-29 16:03.
 */

public class MyAnimation {

    public static AnimationSet getAnimation(int repeats, long duration) {

        //由小变大
        Animation scaleAnim = new ScaleAnimation(0.9f, 1.1f, 0.9f, 1.1f);
        //从左向右
        Animation rotateAnim = new RotateAnimation(-15, 15, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnim.setDuration(duration);
        rotateAnim.setDuration(duration);
        rotateAnim.setRepeatMode(Animation.REVERSE);
        rotateAnim.setRepeatCount(repeats);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnim);
        animationSet.addAnimation(rotateAnim);
        return animationSet;
    }

    public static AnimationSet scal(int repeats, long duration) {

        //由小变大
        Animation scaleAnim = new ScaleAnimation(0.9f, 1.1f, 0.9f, 1.1f);
        //从左向右
        Animation rotateAnim = new RotateAnimation(-15, 15, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnim.setDuration(duration);
        rotateAnim.setDuration(duration);
        rotateAnim.setRepeatMode(Animation.REVERSE);
        rotateAnim.setRepeatCount(repeats);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnim);
        animationSet.addAnimation(rotateAnim);
        return animationSet;
    }
}
