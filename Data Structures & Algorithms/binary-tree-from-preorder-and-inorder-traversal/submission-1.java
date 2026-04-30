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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i],i);
        }
        return build(preorder, inMap, 0, inorder.length-1, new int[]{0});
    }
    public TreeNode build(int[] preorder, HashMap<Integer,Integer> inMap, int start, int end, int[] index){
        if(start>end) return null;

        int rootval = preorder[index[0]++];
        TreeNode node = new TreeNode(rootval);

        int inIndex = inMap.get(rootval);

        node.left = build(preorder,inMap,start,inIndex-1,index);
        node.right = build(preorder,inMap,inIndex+1,end,index);
        return node;

    }
}
