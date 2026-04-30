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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("/");
        int[] index = new int[1];
        return build(values,index);
    }

    public TreeNode build(String[] values, int[] index){
        if(values[index[0]].equals("n")){
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        root.left = build(values, index);
        root.right = build(values, index);
        return root;
    }

    public void preorder(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("n/");
            return;
        } else{
            sb.append(root.val).append("/");
        }
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
}
