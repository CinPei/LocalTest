package com.cin.dr.leetcode;

public class LC69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(5));
    }
    public static int mySqrt(int x) {
        if(x == 0) return 0;
        int l = 0, r=x;
        int result = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if((long) mid * mid <= x){
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
