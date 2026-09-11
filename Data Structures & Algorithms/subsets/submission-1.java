class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        res.add(curr);

        for(int i = 0 ; i < nums.length; i++){
            int size = res.size();
            for(int j = 0 ; j < size; j++){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }

        }



        return res;
        
    }
}
