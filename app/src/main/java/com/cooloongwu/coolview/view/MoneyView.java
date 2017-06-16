package com.cooloongwu.coolview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.cooloongwu.coolview.R;

import java.text.DecimalFormat;

/**
 * 自定义的一个金钱的视图，整数部分字体大，小数部分字体小
 */
public class MoneyView extends View {

    private int moneyColor = Color.WHITE;
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

    private String moneyInteger = "0";    //the integer part of money, The default is 0
    private String moneyDecimal = "0";    //the decimal part of money, The default is 0

    public void setMoney(double money) {
        //formatted as a string type like XX.XX, will be rounded off
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String temp = decimalFormat.format(money);

        //get the integer part
        moneyInteger = String.valueOf((int) money);

        //get the decimal part
        moneyDecimal = temp.substring(temp.length() - 2, temp.length());

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    //未使用XML布局调用一个参数的
    public MoneyView(Context context) {
        super(context);
        init(null, 0);
    }

    //使用了XML布局调用两个参数的
    public MoneyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MoneyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
    }

    /**
     * Update TextPaint and text measurements from attributes
     */
    private void invalidateTextPaintAndMeasurements() {
        textIntegerPaint.setTextSize(moneyIntegerDimension);
        textIntegerPaint.setColor(moneyColor);

        textDotPaint.setTextSize(moneyDotDimension);
        textDotPaint.setColor(moneyColor);

        textDecimalPaint.setTextSize(moneyDecimalDimension);
        textDecimalPaint.setColor(moneyColor);

        //测量整数部分的宽度跟高度
        textIntegerWidth = textIntegerPaint.measureText(moneyInteger);
        Paint.FontMetrics integerFontMetrics = textIntegerPaint.getFontMetrics();
        textIntegerHeight = integerFontMetrics.bottom + integerFontMetrics.top;

        //测量“.”和小数部分的宽度
        textDotWidth = textDotPaint.measureText(".");
        textDecimalWidth = textDecimalPaint.measureText(moneyDecimal);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
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
