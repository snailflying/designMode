package com.aaron.design.bridge;

/**
 * Author：Aaron
 * Time：11/10/2017:2:21 PM
 * 在软件系统中，某些类型由于自身的逻辑，它具有两个或多个维度的变化，那么如何应对这种“多维度的变化”？
 * 如何利用面向对象的技术来使得该类型能够轻松的沿着多个方向进行变化，而又不引入额外的复杂度？
 * <p>
 * 例子：设想如果要绘制圆形、椭圆、正方形，我们至少需要4个形状类，
 * 但是如果绘制的图形需要具有不同的颜色，如红色、绿色、蓝色等，此时至少有如下两种设计方案：
 *
 * •第一种设计方案是为每一种形状都提供一套各种颜色的版本。
 * •第二种设计方案是根据实际需要对形状和颜色进行组合。
 */
public class Client {
    public static void run() {
        Shape redCircle = new CircleShape(100,100, 10, new RedColor());
        Shape greenSquare = new SquareShape(100,100, new GreenColor());

        redCircle.draw();
        greenSquare.draw();
    }
}
