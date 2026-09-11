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

    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preIndex = 0;

        return dfs(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder,int[] inorder, int left, int right){
        if(left > right){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;

        int mid = left;

        while(inorder[mid] != root.val){
            mid++;
        }

        root.left = dfs(preorder, inorder, left, mid - 1);

        root.right = dfs(preorder, inorder, mid + 1, right);

        return root;

    }
}
