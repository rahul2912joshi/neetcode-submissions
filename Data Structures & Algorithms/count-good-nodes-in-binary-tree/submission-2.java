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
    int result = 0;
    public int goodNodes(TreeNode root) {
        findNodes(root,Integer.MIN_VALUE);
        return result;
    }
    public void findNodes(TreeNode root, int maxTillNow){
        if(root==null) return;
        if(root.val >= maxTillNow){
            result++;
            maxTillNow = root.val;
        }
        findNodes(root.left,maxTillNow);
        findNodes(root.right,maxTillNow);
    }
}
