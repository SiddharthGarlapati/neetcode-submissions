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
    StringBuilder sb = new StringBuilder();
    public String serialize(TreeNode root) {
        dfs_serialize(root);
        return sb.toString();

        
    }

    private void dfs_serialize(TreeNode node){
        if(node == null){
            sb.append("N").append(",");
            return;
        }

        sb.append(node.val).append(",");
        dfs_serialize(node.left);
        dfs_serialize(node.right);

    }

    // Decodes your encoded data to tree.
    int pre_indx = 0;
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return dfs_deserialize(nodes,null);    
        
    }

    private TreeNode dfs_deserialize(String[] nodes, TreeNode root){
        if(pre_indx >= nodes.length) return null;
        if(nodes[pre_indx].equals("N")){
            pre_indx++;
            return null;
        }

        root = new TreeNode(Integer.parseInt(nodes[pre_indx]));
        pre_indx++;

        root.left = dfs_deserialize(nodes, root.left);
        root.right = dfs_deserialize(nodes,root.right);

        return root;

    }
}
