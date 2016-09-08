package com.cooloongwu.coolview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.text.DecimalFormat;

/**
 * 自定义的一个金钱的视图，整数部分字体大，小数部分字体小
 */
public class MoneyView extends View {

    private double money = 0;
    private int moneyColor = Color.RED;
    private float moneyIntegerDimension = 0;
    private float moneyDotDimension = 0;
    private float moneyDecimalDimension = 0;

    private TextPaint textIntegerPaint;
    private TextPaint textDotPaint;
    private TextPaint textDecimalPaint;

    private float textIntegerWidth;
    private float textIntegerHeight;
    private float textDotWidth;
    private float textDecimalWidth;

    private String moneyInteger = "200";    //钱的整数部分
    private String moneyDecimal = "05";    //钱的小数部分

    public void setMoney(double money) {
        this.money = money;

        //格式化为XX.XX类型的字符串，会进行四舍五入
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String temp = decimalFormat.format(money);
        Log.e("格式化后的数字", temp);

        moneyInteger = String.valueOf((int) money);
        moneyDecimal = "23";
    }

    //未使用XML布局调用一个参数的
    public MoneyView(Context context) {
        super(context);
        Log.e("调用了", "带一个参数的");
        init(null, 0);
    }

    //使用了XML布局调用两个参数的
    public MoneyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e("调用了", "带二个参数的");
        init(attrs, 0);
    }

    public MoneyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Log.e("调用了", "带三个参数的");
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.MoneyView, defStyle, 0);

        moneyColor = a.getColor(
                R.styleable.MoneyView_moneyColor,
                moneyColor);
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
        moneyIntegerDimension = a.getDimension(
                R.styleable.MoneyView_moneyIntegerDimension,
                moneyIntegerDimension);

        moneyDotDimension = a.getDimension(
                R.styleable.MoneyView_moneyDotDimension,
                moneyDotDimension);

        moneyDecimalDimension = a.getDimension(
                R.styleable.MoneyView_moneyDecimalDimension,
                moneyDecimalDimension);

        a.recycle();

        // Set up a default TextPaint object
        textIntegerPaint = new TextPaint();
        textIntegerPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        textIntegerPaint.setTextAlign(Paint.Align.LEFT);

        textDotPaint = new TextPaint();
        textDotPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        textDotPaint.setTextAlign(Paint.Align.LEFT);

        textDecimalPaint = new TextPaint();
        textDecimalPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        textDecimalPaint.setTextAlign(Paint.Align.LEFT);

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
        textIntegerPaint.setTextSize(moneyIntegerDimension);
        textIntegerPaint.setColor(moneyColor);

        textDotPaint.setTextSize(moneyDotDimension);
        textDotPaint.setColor(moneyColor);

        textDecimalPaint.setTextSize(moneyDecimalDimension);
        textDecimalPaint.setColor(moneyColor);

        //测量整数部分的宽度跟高度
        textIntegerWidth = textIntegerPaint.measureText(moneyInteger);
        Log.e("整数部分的宽度", "" + textIntegerWidth);
        Paint.FontMetrics integerFontMetrics = textIntegerPaint.getFontMetrics();
        textIntegerHeight = integerFontMetrics.bottom + integerFontMetrics.top;

        //测量“.”和小数部分的宽度
        textDotWidth = textDotPaint.measureText(".");
        Log.e("点部分的宽度", "" + textDotWidth);
        textDecimalWidth = textDecimalPaint.measureText(moneyDecimal);
        Log.e("小数部分的宽度", "" + textDecimalWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("调用了", "onDraw()");
        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        // Draw the text.
        canvas.drawText(moneyInteger,
                (contentWidth - textIntegerWidth - textDotWidth - textDecimalWidth) / 2,
                (contentHeight - textIntegerHeight) / 2,
                textIntegerPaint);

        canvas.drawText(".",
                (contentWidth - textIntegerWidth - textDotWidth - textDecimalWidth) / 2 + textIntegerWidth,
                (contentHeight - textIntegerHeight) / 2,
                textDotPaint);

        canvas.drawText(moneyDecimal,
                (contentWidth - textIntegerWidth - textDotWidth - textDecimalWidth) / 2 + textIntegerWidth + textDotWidth,
                (contentHeight - textIntegerHeight) / 2,
                textDecimalPaint);

    }
}
