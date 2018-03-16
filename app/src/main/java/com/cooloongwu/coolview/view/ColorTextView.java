package com.cooloongwu.coolview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;

import com.cooloongwu.coolview.R;

/**
 * 自定义包含不同颜色字的TextView
 * Created by CooLoongWu on 2018-3-16 14:38.
 */

public class ColorTextView extends android.support.v7.widget.AppCompatTextView {
    public ColorTextView(Context context) {
        super(context);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.ColorTextView,
                defStyleAttr,
                0
        );

        String name = typedArray.getString(R.styleable.ColorTextView_name);
        String comment = typedArray.getString(R.styleable.ColorTextView_comment);

        Log.e("name", name);
        Log.e("comment", comment);

        //方法一：使用Html的方式来定义字体颜色
//        String colorName = "<font color = '#fc873d'>" + name + "</font>";
//        String colorComment = "<font color = '#323232'>" + comment + "</font>";
//        setText(Html.fromHtml(colorName + "&nbsp;&nbsp;&nbsp;&nbsp;" + colorComment));

        //方法二：使用SpannableString
        SpannableStringBuilder s = new SpannableStringBuilder(name);
        s.setSpan(
                new ForegroundColorSpan(Color.parseColor("#fc873d")),
                0,
                s.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.append(comment);
        setText(s);


        typedArray.recycle();
    }
}
