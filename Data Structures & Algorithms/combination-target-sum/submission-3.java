class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0,0,target,nums,list);

        return res;
    }

    private void dfs(int i , int curr , int target, int[] nums,List<Integer> list){
        if(curr == target){
            res.add(new ArrayList<>(list));
            return;
        }

        if(curr > target || i == nums.length){
            return;
        }

        list.add(nums[i]);
        dfs(i,curr + nums[i],target, nums,list);
        list.remove(list.size() - 1);
        dfs(i + 1, curr, target,nums, list);
    }
}
