class Solution {

    List<List<Integer>> res; 
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();

        backtrack(nums,0, new ArrayList<>());

        return res;
        
    }

    public void backtrack(int[] nums, int i, List<Integer> curr){
        
        if(i == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(nums[i]);
        backtrack(nums, i+1,curr);

        curr.remove(curr.size() - 1);

        backtrack(nums,i+1, curr);

    }
}
