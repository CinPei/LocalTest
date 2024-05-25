package com.cin.dr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,2,1,2};
        int target = 5;
        List<List<Integer>> lists = combinationSum2(nums, target);
        System.out.println(lists);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        int length = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates, target, result, combine, 0, length);
        return result;
    }
    private static void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int index, int length){
        if(index == length){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(combine));
            return;
        }
        for(int i = index; i< length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            combine.add(candidates[i]);
            dfs(candidates,target-candidates[i],result,combine,i+1,length);
            combine.remove(combine.size() - 1);
        }
    }
}
