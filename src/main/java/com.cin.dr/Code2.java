package com.cin.dr;

import java.util.*;

public class Code2 {
    public static void main(String[] args) {
        /*PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.forEach(System.out::println);

        String a = "001";
        System.out.println(Integer.valueOf(a));*/

        /*StringBuilder sb = new StringBuilder();
        sb.append(123456);
        sb.append(7890);
        System.out.println(sb.toString());

        String[] array = new String[]{"123", "987", "978"};
        Arrays.sort(array, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        Arrays.asList(array).forEach(System.out::println);*/

        lengthOfLongestSubstring("pwwkew");

    }

    public static  int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int slow = 0, fast = 1;
        Set<Character> occupied = new HashSet<Character>();
        occupied.add(s.charAt(0));
        int result = 1;
        while(fast <= length-1 && slow <= length-1){
            while(fast <= length-1 && !occupied.contains(s.charAt(fast))){
                fast++;
                occupied.add(s.charAt(fast));
            }
            char f = s.charAt(fast);
            char w = s.charAt(slow);
            result = Math.max(result, occupied.size());
            if(slow <= length-1){
                occupied.remove(s.charAt(slow));
                slow++;
            }
        }
        return result;
    }
}
