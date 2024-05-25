package com.cin.dr.concurrent.test2;


import com.cin.dr.concurrent.test.utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService的使用之定时执行任务
 */

@Slf4j
public class Test27 {




    public static void main(String[] args) {
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
//        log.debug("start...");
        // 第一个参数是最开始的时候延迟的时间，第二个参数是执行下一次任务的时间隔，这个时间间隔包括执行打印log.debug("running...");的时间
//        pool.scheduleAtFixedRate(() -> {
//            log.debug("running...");
//        }, 1, 1, TimeUnit.SECONDS);
        
        // 如果睡眠时间被设置为s，那么任务的执行间隔变成了2s
//        pool.scheduleAtFixedRate(() -> {
//            log.debug("running...");
//            utils.sleep(2);
//        }, 1, 1, TimeUnit.SECONDS);


/*        *//**
         * scheduleWithFixedDelay的使用，第二个参数的意思，是执行完
         * log.debug("running...");
         *  utils.sleep(2);
         * 还要再等待1s           
         *//*
        pool.scheduleWithFixedDelay(() -> {
            log.debug("running...");
            utils.sleep(2);
        }, 1, 1, TimeUnit.SECONDS);*/

        LocalDateTime now = LocalDateTime.now();
        long period = 1000 * 60 * 60 *24 * 7;
        LocalDateTime time = now.withHour(18).withMinute(0).withSecond(0).withNano(0).with(DayOfWeek.THURSDAY);
        if (now.compareTo(time) > 0){
            time.plusWeeks(1);
        }
        long init = Duration.between(now, time).toMillis();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(() -> {
            System.out.println("running...");
        }, init, period, TimeUnit.MILLISECONDS);
    }
}
