package com.glasgow.mo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class Product implements Serializable {
    static List<Product> productList = new ArrayList<>();// java

    static double VAT = 1.4;
    public static void main(String[] args) {
       Executors.newScheduledThreadPool(3);
       ThreadLocal<String> tl = new ThreadLocal<>();
    }
}
