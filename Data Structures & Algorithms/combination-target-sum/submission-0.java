class Solution {

    List<List<Integer>> res ;
    int tar;
    int n;
    int[] nums_temp;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        tar = target;
        res = new ArrayList<>();
        n = nums.length;
        nums_temp = nums;

        dfs(0,0, new ArrayList<>());

        return res;


        
    }

    private void dfs(int i , int total, List<Integer> curr){
        if( total == tar){
            res.add(new ArrayList<>(curr));
            return;
        }
        if( i >= n || total > tar){
            return;
        }

        curr.add(nums_temp[i]);
        dfs(i, total + nums_temp[i],curr);
        curr.remove(curr.size() - 1);
        dfs(i + 1, total , curr);

    }
}
