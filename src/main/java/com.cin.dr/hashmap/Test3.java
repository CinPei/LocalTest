package com.cin.dr.hashmap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 古春波
 * @Description HashMap
 * @Date 2020/10/2 10:27
 * @Version 1.0
 **/
public class Test3 {

    public static void main(String[] args) {
        // hashmap支持ken和value都为null
        HashMap<Object, Object> map = new HashMap<>();
        Object put = map.put(null, "test" );
        System.out.println(map.get(null));
        ConcurrentHashMap<String, String> cMap = new ConcurrentHashMap<>();
        List<String> list = new ArrayList<>();
        TreeMap<String, String> treeMap = new TreeMap();
    }
    
}
