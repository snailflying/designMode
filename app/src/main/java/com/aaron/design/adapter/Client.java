package com.aaron.design.adapter;

/**
 * Created by aaron on 30/10/2017.
 */

/*
* 类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口。

对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法。

接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类。
* */
public class Client {


    public void testClass(){
        ClassTarget target = new ClassAdapter();
        target.method1();
        target.method2();
    }

    public void testObject(){
        ObjectTarget target = new ObjectAdapter(new ObjectSource());
        target.method1();
        target.method2();
    }


    public void testInterface() {
        InterfaceSource interfaceSource1 = new InterfaceAdapter();
        InterfaceSource interfaceSource2 = new InterfaceAdapter2();
        interfaceSource1.method1();
        interfaceSource1.method2();
        interfaceSource2.method1();
        interfaceSource2.method2();
    }
}
