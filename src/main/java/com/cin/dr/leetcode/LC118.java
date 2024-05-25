package com.cin.dr.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        result.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        result.add(list2);

        for(int i=2; i<numRows; i++){
            List<Integer> listi = new ArrayList<>();
            listi.add(1);
            for(int j=1;j<i;j++){
                int num = 0;
                try {
                    num = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                } catch (Exception e) {
                    System.out.println(i + " " + j);
                }
                listi.add(num);
            }
            listi.add(1);
            result.add(listi);
        }
        return result;
    }
}
