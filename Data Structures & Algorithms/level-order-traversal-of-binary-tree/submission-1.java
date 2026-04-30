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
        if(root==null) return new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            int len = level.size();
            ArrayList<Integer> thisLevel = new ArrayList<>();
            for(int i=0; i<len; i++){
                TreeNode curr = level.poll();
                thisLevel.add(curr.val);
                if(curr.left!=null) level.add(curr.left);
                if(curr.right!=null) level.add(curr.right);
            }
            result.add(thisLevel);
        }
        return result;
    }
}
