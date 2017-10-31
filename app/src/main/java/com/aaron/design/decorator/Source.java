package com.aaron.design.decorator;

/**
 * Created by aaron on 30/10/2017.
 */

public class Source implements SourceInterface {
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
