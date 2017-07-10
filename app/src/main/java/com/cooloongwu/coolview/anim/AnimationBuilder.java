package com.cooloongwu.coolview.anim;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;

import java.util.ArrayList;
import java.util.List;

import static android.animation.ValueAnimator.RESTART;


/**
 * Created by tarek on 6/29/17.
 */


public class AnimationBuilder {


    private static final long DEFAULT_DURATION = 300;
    private static final long DEFAULT_START_DELAY = 0;

    private final List<ValueAnimator> animators = new ArrayList<>();

    private long duration = DEFAULT_DURATION;
    private long startDelay = DEFAULT_START_DELAY;
    private Interpolator interpolator;
    private int repeatCount = 0;
    private int repeatMode = RESTART;

    private MyAnimator animator;
    private View[] views;

    public AnimationBuilder(MyAnimator animator, View... views) {
        this.animator = animator;
        this.views = views;
    }

    private void property(String propertyName, float... values) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(null, propertyName, values);//这里的null有问题
        applyAnimatorProperties(objectAnimator);

    }

    List<ValueAnimator> getAnimators() {
        return animators;
    }

    public AnimationBuilder repeatMode(int repeatMode) {
        this.repeatMode = repeatMode;
        for (ValueAnimator animator : animators) {
            animator.setRepeatMode(repeatMode);
        }
        return this;
    }

    public AnimationBuilder repeatModeSet(int repeatMode) {
        animator.repeatMode(repeatMode);
        return this;
    }

    public AnimationBuilder repeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
        for (ValueAnimator animator : animators) {
            animator.setRepeatCount(repeatCount);
        }
        return this;
    }

    private void applyAnimatorProperties(ValueAnimator animator) {
        animator.setDuration(duration);
        animator.setStartDelay(startDelay);
        animator.setRepeatMode(repeatMode);
        animator.setRepeatCount(repeatCount);
        if (interpolator != null) {
            animator.setInterpolator(interpolator);
        }
        //add animator to the animators list
        this.animators.add(animator);
    }

    public AnimationBuilder rotation(float... values) {
        property("rotation", values);
        return this;
    }
}
