class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,0,nums,target,list);

        return res;        
    }

    private void dfs(int idx, int currSum,  int[] nums, int target, List<Integer> list){
        if(currSum == target){
            res.add(new ArrayList<>(list));
            return;
        }

        if(currSum > target){
            return;
        }

        for(int i = idx ; i < nums.length ; i++ ){
            if(currSum + nums[i] > target){
                break;
            }
            list.add(nums[i]);
            dfs(i,currSum + nums[i], nums, target, list);
            list.remove(list.size() - 1);
        }
        
    }
}
