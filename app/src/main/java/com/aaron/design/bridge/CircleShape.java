package com.aaron.design.bridge;

/**
 * Author：Aaron
 * Time：11/10/2017:3:25 PM
 */
public class CircleShape extends Shape {
    private int x, y, radius;

    public CircleShape(int x, int y, int radius, ColorApi colorApi) {
        super(colorApi);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        //画形状（）
        System.out.println("Drawing Circle  with radius:" + radius + ", x: " + x + ", " + y);
        //画颜色
        colorApi.drawColor();
    }
}
