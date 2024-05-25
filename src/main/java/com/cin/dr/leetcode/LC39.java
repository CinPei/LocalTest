package com.cin.dr.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC39 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
        combinationSum(nums, 7);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        int length = candidates.length;
        dfs(candidates, target, result, combine, 0, length);
        return result;
    }

    private static void dfs(int[] candidates, int target,List<List<Integer>> result,List<Integer> combine,int index,int length){
        if(index == length){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, target, result, combine, index + 1, length);
        if(target >= candidates[index]){
            combine.add(candidates[index]);
            dfs(candidates, target-candidates[index], result, combine, index, length);
            combine.remove(combine.size() - 1);
        }
    }
}
