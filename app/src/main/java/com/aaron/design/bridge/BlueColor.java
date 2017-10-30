package com.aaron.design.bridge;

/**
 * Author：Aaron
 * Time：11/10/2017:3:20 PM
 */
public class BlueColor implements ColorApi {
    @Override
    public void drawColor() {
        System.out.println("draw color: blue.");
    }
}
