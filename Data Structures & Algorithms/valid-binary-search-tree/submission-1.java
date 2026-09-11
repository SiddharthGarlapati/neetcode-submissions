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

    public boolean isValidBST(TreeNode root) {

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return dfs(root,min,max);
        
    }

    private boolean dfs(TreeNode root, int min , int max){

        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }


        return (dfs(root.left,min, root.val) &&
                dfs(root.right, root.val,max));

    }
}
