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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        int level = 0;
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            Integer[] list = new Integer[size];
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();

                int idx = (level % 2 == 0) ? i : size - 1 - i;

                list[idx] = curr.val;

                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            res.add(Arrays.asList(list));
            level++;
        }

        return res;



    }
}