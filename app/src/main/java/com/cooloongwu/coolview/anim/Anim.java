package com.cooloongwu.coolview.anim;

import android.util.Log;
import android.view.View;

/**
 * 控制动画的类
 * Created by CooLoongWu on 2017-6-19 16:56.
 */

public class Anim {

    private static final long DURATION = 1000;
    private static final long NO_DELAY = 0;
    public static final int INFINITE = -1;
    public static final float CENTER_PIVOT = Float.MAX_VALUE;

    private long duration;
    private long delay;
    private boolean repeat;
    private long repeatTimes;
    private float pivotX, pivotY;
    private View target;

    /**
     * 装载动画效果
     *
     * @param action 动画效果
     * @return AnimCreator
     */
    public static AnimCreator with(AnimAction action) {
        return new AnimCreator(action);
    }

    private Anim(AnimCreator animCreator) {
        duration = animCreator.duration;
        delay = animCreator.delay;
        repeat = animCreator.repeat;
        repeatTimes = animCreator.repeatTimes;
        pivotX = animCreator.pivotX;
        pivotY = animCreator.pivotY;
        target = animCreator.target;
    }


    public static class AnimCreator {
        private long duration = DURATION;

        private long delay = NO_DELAY;
        private boolean repeat = false;
        private long repeatTimes = 0;
        private float pivotX = Anim.CENTER_PIVOT, pivotY = Anim.CENTER_PIVOT;
        private View target;

        AnimCreator(AnimAction action) {
            Log.e("AnimCreator", "构造");
        }

        /**
         * 设置动画的目标视图
         *
         * @param target 目标视图
         * @return AnimCreator
         */
        public AnimCreator into(View target) {
            this.target = target;
            Log.e("AnimCreator", "into()");
            return this;
        }

        /**
         * 设置动画持续的时间
         *
         * @param duration 持续的时间
         * @return AnimCreator
         */
        public AnimCreator setDuration(long duration) {
            this.duration = duration;
            Log.e("AnimCreator", "setDuration(" + duration + ")");
            return this;
        }

        /**
         * 动画立即开始
         *
         * @return AnimCreator
         */
        public AnimCreator start() {
            this.delay = 0;
            Log.e("AnimCreator", "start()");
            return this;
        }

        /**
         * 动画延迟开始
         *
         * @param delay 延迟时间
         * @return AnimCreator
         */
        public AnimCreator startDelay(long delay) {
            this.delay = delay;
            Log.e("AnimCreator", "start(+" + delay + ")");
            return this;
        }


        /**
         * 动画重复次数
         *
         * @param times 次数
         * @return AnimCreator
         */
        public AnimCreator setRepeat(int times) {
            Log.e("AnimCreator", "setRepeat(" + times + ")");
            if (times < INFINITE) {
                throw new RuntimeException("Can not be less than -1, -1 is infinite loop");
            }
            repeat = times != 0;
            repeatTimes = times;
            return this;
        }
    }
}
