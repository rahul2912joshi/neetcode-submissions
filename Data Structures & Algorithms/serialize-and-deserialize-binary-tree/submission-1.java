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
        preorder(sb,root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] valdata = data.split("#");
        int[] index = new int[1];
        return build(valdata, index);
    }

    public void preorder(StringBuilder sb, TreeNode root){
        if(root==null){
            sb.append("n#");
            return;
        }
        sb.append(root.val).append("#");
        preorder(sb,root.left);
        preorder(sb,root.right);
    }

    public TreeNode build(String[] valdata, int[] index){
        if(valdata[index[0]].equals("n")){
            index[0]++;
            return null;
        }
        int value = Integer.parseInt(valdata[index[0]]);
        TreeNode node = new TreeNode(value);
        index[0]++;
        node.left = build(valdata,index);
        node.right = build(valdata,index);
        return node;
    }
}
//1 2 n n 3 4 n n 5 n n
