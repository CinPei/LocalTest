package com.cin.dr.leetcode;

import java.util.*;

public class LC347 {
    public static void main(String[] args) {
        int[] result = topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);
        System.out.println(result);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int nLen = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        Set<Integer> set = map.keySet();
        for(int key:set){
            int count = map.get(key);
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{key, count});
                }
            } else if(queue.size() < k){
                queue.offer(new int[]{key, count});
            }
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = queue.poll()[0];
        }
        return result;
    }



}
