package com.cooloongwu.coolview.anim;

import android.view.animation.AnimationSet;

import com.cooloongwu.coolview.anim.actions.Test1Action;
import com.cooloongwu.coolview.anim.actions.Test2Action;

/**
 * 动画描述
 * Created by CooLoongWu on 2017-6-20 15:44.
 */

public enum AnimAction {

    Test1 {
        @Override
        public AnimationSet getAnimationSet(int repeats, long duration) {
            return Test1Action.animationSet(repeats, duration);
        }
    },

    Test2 {
        @Override
        public AnimationSet getAnimationSet(int repeats, long duration) {
            return Test2Action.animationSet(repeats, duration);
        }
    };

    public abstract AnimationSet getAnimationSet(int repeats, long duration);
}
