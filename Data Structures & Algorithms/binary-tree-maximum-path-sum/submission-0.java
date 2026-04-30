/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;

        int maxLeft = Math.max(0,dfs(root.left));
        int maxRight =Math.max(0,dfs(root.right));

        int maxThroughNode = root.val + maxLeft + maxRight;

        maxSum = Math.max(maxSum,maxThroughNode);

        return root.val + Math.max(maxLeft,maxRight);
    }
}
