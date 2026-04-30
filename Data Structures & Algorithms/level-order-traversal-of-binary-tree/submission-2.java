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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            int len = level.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0; i<len; i++){
                TreeNode currNode = level.poll();
                currLevel.add(currNode.val);
                if(currNode.left!=null) level.add(currNode.left);
                if(currNode.right!=null) level.add(currNode.right);
            }
            result.add(currLevel);
        }
        return result;
    }
}
