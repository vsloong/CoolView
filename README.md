# 自定义视图类

可能每位开发者都需要更便捷、更高效的视图类来增加开发效率，并将其中承载的知识及价值传播给他人，
**CoolView** 是我自己在开发中所遇到的需要自定义视图的类，并在逐步添加完善。 
您可以使用 CoolView：

> * 方便的集成、使用某些View
> * 参考代码并封装成您自己的视图

### 1. MoneyView
MoneyView是一个金钱类的视图，整数部分字体大，小数部分字体小，如下所示：
![image](./pictures/picture1.png)

####使用方法
布局中使用示例：
```
    <com.cooloongwu.coolview.MoneyView
        android:id="@+id/money_view"
        android:layout_width="match_parent"
        android:layout_height="180dp"
        android:background="@color/colorPrimary"
        app:moneyColor="@android:color/white"
        app:moneyDecimalDimension="24sp"
        app:moneyDotDimension="32sp"
        app:moneyIntegerDimension="48sp" />
```

java中使用示例：
```
    MoneyView moneyView = (MoneyView) findViewById(R.id.money_view);
    //double类型，可以是“.3”、“.223”、“11”、“11.”，注意小数点2位后会进行五舍六入
    moneyView.setMoney(1560.);
```


特殊值说明：
> * 当setMoney(.3)，  显示0.30
> * 当setMoney(.301)，显示0.30
> * 当setMoney(.306)，显示0.31
> * 当setMoney(11)，  显示11.00
> * 当setMoney(11.)， 显示11.00

作者 [@CooLoongWu][2]  
2016 年 09月 08日 


[1]: https://cooloongwu.github.io/
[2]: http://blog.csdn.net/u010976213


