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
    StringBuilder sb;
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        dfsSerialize(root);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode root){

        if(root == null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        dfsSerialize(root.left);
        dfsSerialize(root.right);

    }

    // Decodes your encoded data to tree.
    int i = 0;
    public TreeNode deserialize(String data) {

        String[] vals = data.split(",");

        return dfsDeserialize(vals);    
    }

    private TreeNode dfsDeserialize(String[] vals){

        if(vals[i].equals("N")){
            i++;
            return null;
        }

        TreeNode root = new TreeNode (Integer.parseInt(vals[i]));
        i++;
        root.left = dfsDeserialize(vals);
        root.right = dfsDeserialize(vals);

        return root;
    }


}
