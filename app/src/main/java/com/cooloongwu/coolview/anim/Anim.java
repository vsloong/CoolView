package com.cooloongwu.coolview.anim;

import android.util.Log;
import android.widget.ImageView;

/**
 * 控制动画的类
 * Created by CooLoongWu on 2017-6-19 16:56.
 */

public class Anim {

    private ImageView img;

    private Anim(Builder builder) {
        this.img = builder.img;
    }

    public void showSomething() {
        Log.e("测试", "视图的ID：" + img.getId());
    }

    public static class Builder {
        private ImageView img;

        private Builder(ImageView imageView) {
            this.img = imageView;
        }

        public static Builder into(ImageView img) {
            return new Builder(img);
        }

        public Anim build() {
            return new Anim(this);
        }
    }


}
