package com.cin.dr;

import org.openjdk.jol.info.ClassLayout;

public class BiasedLock {
    public static void main(String[] args) throws InterruptedException {
        Dog d = new Dog();
//        System.out.println(d.hashCode());//会禁用对象的偏向锁
        new Thread(() -> {
            System.out.println(ClassLayout.parseInstance(d).toPrintable(d));
            synchronized(d){
                System.out.println(ClassLayout.parseInstance(d).toPrintable(d));
            }
            System.out.println(ClassLayout.parseInstance(d).toPrintable(d));
            synchronized (BiasedLock.class){
                BiasedLock.class.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (BiasedLock.class){
                try{
                    BiasedLock.class.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(ClassLayout.parseInstance(d).toPrintable(d));
            synchronized(d){
                System.out.println(ClassLayout.parseInstance(d).toPrintable(d));
            }
            System.out.println(ClassLayout.parseInstance(d).toPrintable(d));
        }, "t2").start();

    }
}

class Dog {

}
