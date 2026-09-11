class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        perms(nums,0);

        return res;
        
    }

    public void perms(int[] nums, int i){
        if( i == nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int k = 0 ; k < nums.length; k++){
                curr.add(nums[k]);
            }
            res.add(curr);
            return;
        }


        for(int j = i ; j < nums.length; j++){
            swap(nums,i,j);
            perms(nums, i+1);
            swap(nums,i,j);
        }

    }

    public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
