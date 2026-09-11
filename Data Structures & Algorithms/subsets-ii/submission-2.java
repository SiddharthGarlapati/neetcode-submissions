class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, list);

        return res;
    }

    private void dfs(int i , int[] nums , List<Integer> list){
        if(i == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        dfs(i + 1, nums, list);
        list.remove(list.size() - 1);

        while( i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }

        dfs(i+1, nums, list);

    }
}
