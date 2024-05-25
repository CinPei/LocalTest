package com.cin.dr.concurrent.test;

import lombok.extern.slf4j.Slf4j;

import static com.cin.dr.concurrent.test.utils.sleep;

@Slf4j
public class Test28_1 {
    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            while (count >0){
                sleep(2);
                count--;
                log.debug("count:{}",count);
            }
        },"t1").start();
        new Thread(() -> {
            while (count < 20){
                sleep(2);
                count++;
                log.debug("count:{}",count);
            }
        }, "t2").start();
    }
}
