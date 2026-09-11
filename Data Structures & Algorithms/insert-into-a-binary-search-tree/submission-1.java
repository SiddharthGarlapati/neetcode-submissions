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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        return dfs(root,val);


    }

    private TreeNode dfs(TreeNode root, int val){

        if(root == null){
            return new TreeNode(val);
        }

        if( val < root.val){
            root.left = dfs(root.left,val);
        }

        if(val > root.val){
            root.right = dfs(root.right,val);
        }

        return root;
    }
}