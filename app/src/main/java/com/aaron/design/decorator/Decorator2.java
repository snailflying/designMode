package com.aaron.design.decorator;

/**
 * Created by aaron on 30/10/2017.
 */

public class Decorator2 implements SourceInterface {
    private SourceInterface sourceInterface;

    public Decorator2(SourceInterface sourceInterface) {
        super();
        this.sourceInterface = sourceInterface;
    }

    @Override
    public void method() {
        System.out.println("Decorator2 before decorator!");
        sourceInterface.method();
        System.out.println("Decorator2 after decorator!");
    }
}
