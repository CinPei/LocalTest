package com.cin.dr.leetcode;

public class LC33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0] == target ? 0:-1;
        }
        int left = 0,right = len-1;
        while(left <= right){
            int mid = (right+left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid +1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
