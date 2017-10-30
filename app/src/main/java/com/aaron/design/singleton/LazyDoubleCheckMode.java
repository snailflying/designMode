package com.aaron.design.singleton;

/**
 * Author：Aaron
 * Time：05/10/2017:2:17 PM
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class LazyDoubleCheckMode {
    private static LazyDoubleCheckMode instance;

    //让构造函数为 private，这样该类就不会被实例化
    private LazyDoubleCheckMode() {
    }

    //获取唯一可用的对象
    public static LazyDoubleCheckMode getInstance() {
        //第一重校验
        if (instance == null) {
            //线程安全
            synchronized (LazyDoubleCheckMode.class) {
                //第二重校验
                if (instance == null) {
                    instance = new LazyDoubleCheckMode();
                }
            }
        }
        return instance;
    }
}
