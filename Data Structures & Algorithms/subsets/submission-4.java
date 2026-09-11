class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0,nums,list);
        return res;
    }

    private void dfs(int idx , int[] nums, List<Integer> list){
        res.add(new ArrayList<>(list));

        for(int i = idx ; i < nums.length ; i++){
            list.add(nums[i]);
            dfs(i + 1 , nums, list);
            list.remove(list.size() - 1);
        }
    }
}
