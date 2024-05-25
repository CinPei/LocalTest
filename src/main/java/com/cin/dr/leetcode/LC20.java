package com.cin.dr.leetcode;

public class LC20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    public static boolean isValid(String s) {
        while(true){
            int len = s.length();
            s= s.replace("{}","").replace("[]","").replace("()","");
            if(len == s.length()) return len==0;
        }
    }
}
