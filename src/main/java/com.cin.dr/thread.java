package com.cin.dr;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class thread {

    static int r = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*FutureTask<Integer> task = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("run...");
                sleep(3000);
                return 100;
            }
        });

        Thread t = new Thread(task);
        t.start();
        Integer integer = task.get();
        System.out.println(integer);*/
        /*new Thread(() -> {
            while (true){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("fuck");
            }
        },"this is name").start();*/
        /*Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                try {
                    System.out.println("ready for sleep");
                    Thread.sleep(2000);
                    System.out.println("wake up");
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        System.out.println(t1.getState());
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
        System.out.println(t1.getState());*/
        /*Runnable task1 = () -> {
            int count = 0;
            for (;;){
                System.out.println("----->1:"+count++);
            }
        };*/
        /*Runnable task2 = () -> {
            int count = 0;
            for (;;){
//                Thread.yield();
                System.out.println("       ----->2:"+count++);
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();*/
        System.out.println("开始");
        Thread t1 = new Thread(() -> {
            System.out.println("开始");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束");
            r = 10;
        }, "t1");
        t1.start();
        t1.join();
        System.out.println("结果为:" + r);
        System.out.println("结束");

/*        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程任务执行");

                try {
                    Thread.sleep(10000); // wait, join
              }  } catch (InterruptedException e) {
                    //e.printStackTrace();
                    System.out.println("被打断");
                }
            }
        };
        t1.start();
        System.out.println(t1.getState());
        Thread.sleep(500);
        System.out.println("111是否被打断？"+t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.getState());
        System.out.println("222是否被打断？"+t1.isInterrupted());
        Thread.sleep(500);
        System.out.println(t1.getState());
        System.out.println("222是否被打断？"+t1.isInterrupted());
        System.out.println("主线程");*/

        // Sync 继承自 AQS
    }}
