package com.aaron.design.bridge;

/**
 * Author：Aaron
 * Time：11/10/2017:3:50 PM
 */
public class SquareShape extends Shape {
    private int x, y;

    public SquareShape(int x, int y, ColorApi colorApi) {
        super(colorApi);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        //画形状（）
        System.out.println("Drawing Circle  with x: " + x + ", " + y);
        //画颜色
        colorApi.drawColor();
    }
}
