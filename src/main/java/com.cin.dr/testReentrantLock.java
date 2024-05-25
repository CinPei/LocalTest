package com.cin.dr;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class testReentrantLock {
    static ReentrantLock lock = new ReentrantLock();
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    public static void main(String[] args) throws InterruptedException {
//        //创建一个新的条件变量
//        Condition condition1 = lock.newCondition();
//        Condition condition2 = lock.newCondition();
//
//        lock.lock();
//        condition1.await();
//
//        condition1.signal();
//        condition1.signalAll();

        Object o = new Object();
        synchronized (o) {
            System.out.println(o.hashCode());


        }
    }
}
