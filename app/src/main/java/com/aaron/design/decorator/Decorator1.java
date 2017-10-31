package com.aaron.design.decorator;

/**
 * Created by aaron on 30/10/2017.
 */

public class Decorator1 implements SourceInterface {
    private SourceInterface sourceInterface;

    public Decorator1(SourceInterface sourceInterface) {
        super();
        this.sourceInterface = sourceInterface;
    }

    @Override
    public void method() {
        System.out.println("Decorator1 before decorator!");
        sourceInterface.method();
        System.out.println("Decorator1 after decorator!");
    }
}
