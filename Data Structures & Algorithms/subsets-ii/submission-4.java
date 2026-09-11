class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(0, nums, list);

        return res;
        
    }

    private void dfs(int idx, int[] nums, List<Integer> list){
        res.add(new ArrayList<>(list));

        Set<Integer> used = new HashSet<>();

        for(int i =  idx ; i < nums.length ; i++){

            if(used.contains(nums[i])){
                continue;
            }

            used.add(nums[i]);

            list.add(nums[i]);
            dfs(i + 1,nums, list );
            list.remove(list.size() - 1);
        }

    }
}
