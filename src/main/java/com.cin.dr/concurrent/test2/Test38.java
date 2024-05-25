package com.cin.dr.concurrent.test2;

import com.cin.dr.concurrent.test.utils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;


@Slf4j
public class Test38 {

    public static void main(String[] args) throws InterruptedException {
            CountDownLatch latch = new CountDownLatch(3);
            new Thread(() -> {
                log.debug("begin...");
                utils.sleep(1);
                latch.countDown();
                log.debug("end...{}", latch.getCount());
            }).start();
            new Thread(() -> {
                log.debug("begin...");
                utils.sleep(1);
                latch.countDown();
                log.debug("end...{}", latch.getCount());
            }).start();
            new Thread(() -> {
                log.debug("begin...");
                utils.sleep(2);
                latch.countDown();
                log.debug("end...{}", latch.getCount());
            }).start();
            log.debug("waiting...");
            latch.await();
            log.debug("wait end...");

        }
        
        

    }
    


