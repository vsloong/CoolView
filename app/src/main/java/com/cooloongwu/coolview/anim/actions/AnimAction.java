package com.cooloongwu.coolview.anim.actions;

import android.view.animation.AnimationSet;

/**
 * 动画描述
 * Created by CooLoongWu on 2017-6-20 15:44.
 */

public enum AnimAction {

    Test1 {
        @Override
        public AnimationSet getAnimation(int repeats, long duration) {
            return TestAction.animationSet(repeats, duration);
        }
    },

    Test2 {
        @Override
        public AnimationSet getAnimation(int repeats, long duration) {
            return TestAction.animationSet2(repeats, duration);
        }
    };

    public abstract AnimationSet getAnimation(int repeats, long duration);
}
