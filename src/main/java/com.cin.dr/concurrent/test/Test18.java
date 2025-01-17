package com.cin.dr.concurrent.test;


import lombok.extern.slf4j.Slf4j;

import static com.cin.dr.concurrent.test.test.getObjectHeader;

@Slf4j
public class Test18 {

    public static void main(String[] args) throws InterruptedException {
        Test1 t = new Test1();
        test.parseObjectHeader(getObjectHeader(t));

        synchronized (t){
            test.parseObjectHeader(getObjectHeader(t));
        }
        test.parseObjectHeader(getObjectHeader(t));
    }
}
