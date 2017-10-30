package com.aaron.design.adapter;

/**
 * Created by aaron on 30/10/2017.
 */

public class ObjectAdapter implements ObjectTarget {

    private ObjectSource source;

    public ObjectAdapter(ObjectSource source){
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the object target method!");
    }
}
