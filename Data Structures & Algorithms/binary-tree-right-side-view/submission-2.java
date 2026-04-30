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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            int len = level.size();
            for(int i=0; i<len; i++){
                TreeNode curr = level.poll();
                if(curr.left!=null) level.add(curr.left);
                if(curr.right!=null) level.add(curr.right);
                if(i==len-1) result.add(curr.val);
            }
        }
        return result;
    }
}
