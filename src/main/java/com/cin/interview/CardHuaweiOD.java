package com.cin.interview;
import java.util.*;
import java.util.Scanner;

public class CardHuaweiOD {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String[] str1 = in.nextLine().split(" ");
            String[] str2 = in.nextLine().split(" ");
            int n = str1.length;
            int[] used = new int[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, dfs(str1, str2, i, used, 1));
            }
            System.out.println(ans);
        }
        public static int dfs(String[] str1, String[] str2, int i, int[] used, int ans){
            if(used[i] == 1 || i >= str1.length){
                return ans - 1;
            }
            int res = ans;
            used[i] = 1;
            for (int j = 0; j < str1.length; j++) {
                if(i != j && used[j] == 0){
                    if(str1[i].equals(str1[j]) || str2[i].equals(str2[j])){
                        int t = dfs(str1, str2, j, used, ans + 1);
                        res = Math.max(res, t);
                    }
                }
            }
            used[i] = 0;
            return res;
        }
    }

