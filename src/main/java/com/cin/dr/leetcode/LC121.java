package com.cin.dr.leetcode;

public class LC121 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {

    }

    static int result = 0;
    public static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private static void dfs(TreeNode node, int sum){
        if(node == null){
            result += sum;
            return;
        }

        sum = sum*10 + node.val;
        dfs(node.left, sum);
        dfs(node.right, sum);
    }
}
