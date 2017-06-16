package com.cooloongwu.coolview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 奥林五环的绘制
 */
public class OlympicRingsView extends View {
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private Paint paint4;
    private Paint paint5;

    private int sixth;
    private int radius;

    private List<Integer> colorList = new ArrayList<>();

    private int paintTimes = 0; //控制绘制速度,分100次完成绘制

    public OlympicRingsView(Context context) {
        super(context);
        init();
    }

    //布局文件中用到需添加该构造方法
    public OlympicRingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OlympicRingsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        int screenWidth = getScreenWidth(getContext());
        sixth = screenWidth / 6;
        radius = sixth / 5 * 4;
        int width = radius / 4;

        paint1 = new Paint();
        paint1.setAntiAlias(true);//抗锯齿
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(width);

        paint2 = new Paint();
        paint2.setAntiAlias(true);//抗锯齿
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(width);

        paint3 = new Paint();
        paint3.setAntiAlias(true);//抗锯齿
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(width);

        paint4 = new Paint();
        paint4.setAntiAlias(true);//抗锯齿
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(width);

        paint5 = new Paint();
        paint5.setAntiAlias(true);//抗锯齿
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(width);


        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(width);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制五个圆环
        paint1.setColor(Color.BLUE);
        canvas.drawCircle(sixth, sixth, radius, paint1);

        paint2.setColor(Color.BLACK);
        canvas.drawCircle(sixth * 3, sixth, radius, paint2);

        paint3.setColor(Color.RED);
        canvas.drawCircle(sixth * 5, sixth, radius, paint3);

        paint4.setColor(Color.YELLOW);
        canvas.drawCircle(sixth * 2, (float) (sixth + radius), radius, paint4);

        paint5.setColor(Color.GREEN);
        canvas.drawCircle(sixth * 4, (float) (sixth + radius), radius, paint5);

        //形成穿插效果
        canvas.drawArc(new RectF(sixth / 5, sixth / 5, radius * 2 + sixth / 5, radius * 2 + sixth / 5), -10, 30, false, paint1);
        canvas.drawArc(new RectF(sixth / 5 + sixth * 2, sixth / 5, sixth * 4 - sixth / 5, radius * 2 + sixth / 5), -10, 30, false, paint2);
        canvas.drawArc(new RectF(sixth / 5 + sixth * 2, sixth / 5, sixth * 4 - sixth / 5, radius * 2 + sixth / 5), 90, 30, false, paint2);
        canvas.drawArc(new RectF(sixth / 5 + sixth * 4, sixth / 5, sixth * 6 - sixth / 5, radius * 2 + sixth / 5), 90, 30, false, paint3);

        paintTimes++;
        if (paintTimes <= 166) {
            canvas.drawArc(new RectF(sixth / 5 + sixth * 2, sixth / 5 + sixth * 5, sixth * 4 - sixth / 5, radius * 2 + sixth / 5 + sixth * 5), 135, paintTimes * 2, false, paint3);
            invalidate(); //实现动画的关键点
        } else {
            canvas.drawArc(new RectF(sixth / 5 + sixth * 2, sixth / 5 + sixth * 5, sixth * 4 - sixth / 5, radius * 2 + sixth / 5 + sixth * 5), 135, paintTimes * 2, false, paint3);
        }

    }

    private int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public void setColorList(List<Integer> list) {
        colorList.clear();
        colorList.addAll(list);
    }
}
