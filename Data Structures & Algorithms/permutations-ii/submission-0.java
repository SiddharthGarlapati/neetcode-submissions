class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,nums);
        return res;
    }

    private void dfs(int idx, int[] nums){

        if(idx == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }

            res.add(list);
            return;
        }

        Set<Integer> used = new HashSet<>();


        for(int i = idx ; i < nums.length ; i++){

            if(used.contains(nums[i])){
                continue;
            }

            used.add(nums[i]);

            swap(i,idx,nums);

            dfs(idx + 1, nums);

            swap(i,idx,nums);
            
        }
    }

    private void swap(int i , int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}