package com.aaron.design.decorator;

/**
 * Created by aaron on 30/10/2017.
 * <p>
 * <p>
 * 顾名思义，装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例，关系图如下：
 * Source类是被装饰类，Decorator类是一个装饰类，可以为Source类动态的添加一些功能，代码如下：
 */

public class Client {

    public void testDecorator() {
        //装饰模式可以无限叠加
        SourceInterface sourceInterface = new Source();
        SourceInterface target1 = new Decorator1(sourceInterface);
        SourceInterface target2 = new Decorator2(target1);
        target2.method();

    }
}
