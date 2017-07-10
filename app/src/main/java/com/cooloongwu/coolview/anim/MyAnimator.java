package com.cooloongwu.coolview.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制动画的类
 * Created by CooLoongWu on 2017-7-10 16:30.
 */

public class MyAnimator {
    private long duration = -1;
    private long startDelay = -1;
    private int repeatMode = -2;
    private int repeatCount = -2;

    private Interpolator interpolator;
    private AnimationListener animationListener;

    private List<AnimationBuilder> animationBuilders = new ArrayList<>();

    private AnimatorSet animatorSet;

    private MyAnimator prev;
    private MyAnimator next;

    AnimationBuilder addAnimationBuilder(View... views) {
        AnimationBuilder animationBuilder = new AnimationBuilder(this, views);
        animationBuilders.add(animationBuilder);
        return animationBuilder;
    }

    public static AnimationBuilder animate(View... views) {
        MyAnimator viewAnimator = new MyAnimator();
        return viewAnimator.addAnimationBuilder(views);
    }

    MyAnimator start() {
        if (prev != null) {
            prev.start();
        } else {
            animatorSet = createAnimatorSet();
            animatorSet.start();
        }
        return this;
    }

    private AnimatorSet createAnimatorSet() {
        List<Animator> animators = new ArrayList<>();
        for (AnimationBuilder animationBuilder : animationBuilders) {
            List<ValueAnimator> animatorList = animationBuilder.getAnimators();
            animators.addAll(animatorList);
            if (repeatMode != -2) {
                animationBuilder.repeatMode(repeatMode);
            }

            if (repeatCount != -2) {
                animationBuilder.repeatCount(repeatCount);
            }
        }

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animators);

        if (duration != -1) {
            animatorSet.setDuration(duration);
        }

        if (startDelay != -1) {
            animatorSet.setStartDelay(startDelay);
        }


        if (interpolator != null) {
            animatorSet.setInterpolator(interpolator);
        }

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (animationListener != null) {
                    animationListener.onStart();
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (animationListener != null) {
                    animationListener.onStop();
                }
                if (next != null) {
                    next.prev = null;
                    next.start();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });

        return animatorSet;
    }

    public void cancel() {
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (next != null) {
            next.cancel();
            next = null;
        }
    }

    MyAnimator duration(long duration) {
        this.duration = duration;
        return this;
    }

    MyAnimator startDelay(long startDelay) {
        this.startDelay = startDelay;
        return this;
    }

    MyAnimator interpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }

    MyAnimator repeatMode(int repeatMode) {
        this.repeatMode = repeatMode;
        return this;
    }

    MyAnimator repeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    void setAnimationListener(AnimationListener animationListener) {
        this.animationListener = animationListener;
    }
}
