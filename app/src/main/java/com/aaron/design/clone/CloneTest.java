package com.aaron.design.clone;

/**
 * Author：Aaron
 * Time：24/10/2017:7:08 PM
 */
public class CloneTest {
    public void test() throws CloneNotSupportedException {
        //创建学生对象
        Student s = new Student();
        s.setName("林青霞");
        s.setAge(27);

        //克隆学生对象
        Object obj = s.clone();
        Student s2 = (Student)obj;
        System.out.println("---------");

        System.out.println("s1---"+s.getName()+"---"+s.getAge());
        System.out.println("s2---"+s2.getName()+"---"+s2.getAge());

        //以前的做法
        Student s3 = s;
        System.out.println("s3---"+s3.getName()+"---"+s3.getAge());
        System.out.println("---------");

        //其实是有区别的
        s3.setName("刘意");
        s3.setAge(30);
        System.out.println("s1---"+s.getName()+"---"+s.getAge());
        System.out.println("s2---"+s2.getName()+"---"+s2.getAge());
        System.out.println("s3---"+s3.getName()+"---"+s3.getAge());
        System.out.println("---------");

        //把克隆的改一下呢？
        s2.setName("克隆改的名称");
        s2.setAge(66);
        System.out.println("s1---"+s.getName()+"---"+s.getAge());
        System.out.println("s2---"+s2.getName()+"---"+s2.getAge());
        System.out.println("s3---"+s3.getName()+"---"+s3.getAge());

        //也就是说把一个对象的引用赋值给一个引用，当这个引用发什么该改变的时候，同一个引用指向的对象会发生改变，但是克隆的不会变化，
        //把克隆的对象改变他的一些属性，那么也不会影响到其他的对象的值的改变

    }
}
