package com.cin.dr.concurrent.test2;

public class Test43 {
    static ThreadLocal<String> test1 = new ThreadLocal<String>();
    static ThreadLocal<String> test2 = new ThreadLocal<String>();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.set("test1StrTh1");
                test2.set("test2StrTh1");
                System.out.println(test1.get());
                System.out.println(test2.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.set("test1StrTh2");
                test2.set("test2StrTh2");
                System.out.println(test1.get());
                System.out.println(test2.get());
            }
        }).start();
    }

}
