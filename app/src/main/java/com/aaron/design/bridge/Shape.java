package com.aaron.design.bridge;

/**
 * Author：Aaron
 * Time：11/10/2017:3:22 PM
 *
 * 除将ColorApi放在构造函数内，也可以用一个setColor(ColorApi colorApi)传递。
 */
public abstract class Shape {
    protected ColorApi colorApi;
    protected Shape(ColorApi colorApi){
        this.colorApi = colorApi;
    }

    public abstract void draw();
}
