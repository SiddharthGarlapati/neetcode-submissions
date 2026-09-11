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
    int pre_indx = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        for( int i = 0 ; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return DFSbuildTree(preorder, inorder, 0, inorder.length - 1);
        
    }

    private TreeNode DFSbuildTree(int[] preorder, int[] inorder, int left, int right){
        if( left > right ){
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre_indx]);
        pre_indx++;

        int index = map.get(root.val);

        root.left = DFSbuildTree(preorder, inorder, left, index - 1);
        root.right = DFSbuildTree(preorder,inorder, index + 1, right);

        return root;

    }
}
