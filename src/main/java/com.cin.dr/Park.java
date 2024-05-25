package com.cin.dr;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

@Slf4j
public class Park {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("park...");//breakpoint
            LockSupport.park();
            log.debug("resume...");
        }, "t1");
        t1.start();
        sleep(100);//breakpoint
        log.debug("unpark...");
        LockSupport.unpark(t1);//breakpoint
    }
}
