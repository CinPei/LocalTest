package com.cin.dr.concurrent.test2;


import com.cin.dr.concurrent.test.utils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue 0容量大小的队列测试
 */
@Slf4j
public class Test20_single {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            log.debug("1");
            int i = 1/0;
        });

        executor.execute(() -> {
            log.debug("2");
        });

        executor.execute(() -> {
            log.debug("3");
        });
    }
}
