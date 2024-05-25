package com.cin.dr.concurrent.test;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

@Slf4j
/**
 * 测试ReentrantLock为可重入锁，一个线程对lock多次调用lock.lock不报错，说明可以重入
 */
public class Test30 {
    ReentrantLock l = new ReentrantLock();



    public static void main(String[] args) {
        new Test30().m1();
    }


    final ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    Semaphore semaphore = new Semaphore(3);
    CountDownLatch latch = new CountDownLatch(3);
    CyclicBarrier barrier = new CyclicBarrier(3);
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


    public void m1 (){

        lock.lock();
        try{
            log.info("m1 is running");
            m2();
        }finally {
            
        }
    }

    public void m2 (){

        lock.lock();
        try{
            // 这个代码可以执行，说明可以重入锁
            log.info("m2 is running");
            m3();
        }finally {

        }
    }

    public void m3 (){

        lock.lock();
        try{
            log.info("m3 is running");
        }finally {

        }
    }

}
