package com.cin.dr.leetcode;

public class LC74 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1}}, 1));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = findFirstCol(matrix, target);
        if(row < 0){
            return false;
        }
        return findFirstRow(matrix[row], target);
    }
    private static int findFirstCol(int[][] matrix, int target){
        int l = 0, r=matrix.length-1;
        int result = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(matrix[mid][0] <= target){
                l = mid+1;
                result = mid;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private static boolean findFirstRow(int[] row, int target){
        int l=0, r= row.length-1;
        int result = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(row[mid] == target){
                return true;
            } else if(row[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
