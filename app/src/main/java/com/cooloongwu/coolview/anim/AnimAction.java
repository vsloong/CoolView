package com.cooloongwu.coolview.anim;

import android.view.animation.Animation;

import com.cooloongwu.coolview.anim.actions.Test1Action;
import com.cooloongwu.coolview.anim.actions.Test2Action;

/**
 * 动画描述
 * Created by CooLoongWu on 2017-6-20 15:44.
 */

public enum AnimAction {

    Test1 {
        @Override
        public Animation getAnimation(int repeats, long duration) {
            return Test1Action.animation(repeats, duration);
        }
    },

    Test2 {
        @Override
        public Animation getAnimation(int repeats, long duration) {
            return Test2Action.animation(repeats, duration);
        }
    };

    public abstract Animation getAnimation(int repeats, long duration);
}
