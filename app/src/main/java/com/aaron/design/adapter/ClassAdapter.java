package com.aaron.design.adapter;

/**
 * Created by aaron on 30/10/2017.
 */

public class ClassAdapter extends ClassSource implements ClassTarget {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
