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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) return root;
        TreeNode node1=null,node2=null;
        if(p.val < q.val){
            node1= p;
            node2=q;
        } else{
            node1=q;
            node2=p;
        }

        if(node1.val < root.val && node2.val > root.val) return root;
        if(node1.val < root.val && node2.val < root.val){
            return lowestCommonAncestor(root.left, node1,node2);
        } else if(node1.val > root.val && node2.val > root.val){
            return lowestCommonAncestor(root.right, node1, node2);
        }
        return root;
    }
}
