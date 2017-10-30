package com.aaron.design.singleton;


/**
 * Author：Aaron
 * Time：05/10/2017:2:17 PM
 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
 * 因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class LazyMode {

    private static LazyMode instance;

    //让构造函数为 private，这样该类就不会被实例化
    private LazyMode() {
    }

    //获取唯一可用的对象
    public static LazyMode getInstance() {
        if (instance == null) {
            instance = new LazyMode();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}