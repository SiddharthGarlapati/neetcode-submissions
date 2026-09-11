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
    int max_value = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        int res = DFS(root);
        return Math.max(res,max_value);
        
    }

    private int DFS(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = Math.max(DFS(root.left), 0);
        int rightSum = Math.max(DFS(root.right),0);

        max_value = Math.max(max_value, leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }
}
