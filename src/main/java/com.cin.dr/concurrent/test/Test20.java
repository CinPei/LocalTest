package com.cin.dr.concurrent.test;

import static com.cin.dr.concurrent.test.test.getObjectHeader;

public class Test20 {
    public static void main(String[] args) throws InterruptedException {
        Test1 t = new Test1();
        t.hashCode();
        test.parseObjectHeader(getObjectHeader(t));

        synchronized (t){
            test.parseObjectHeader(getObjectHeader(t));
        }
        test.parseObjectHeader(getObjectHeader(t));
    }
}
