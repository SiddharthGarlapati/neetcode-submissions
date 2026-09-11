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

        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    private boolean isValid(TreeNode root, int left_b , int right_b){

        if(root == null){
            return true;
        }

        if(root.val > left_b && root.val < right_b){
            return (isValid(root.left,left_b, root.val) && 
                    isValid(root.right,root.val, right_b));
        }
        else{
            return false;
        }
    }
}
