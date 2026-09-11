class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        
        for(int i = 0 ; i < n ; i++){
            int a = nums[i];
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = n - 1;

            while(l < r){
                int sum = a + nums[l] + nums[r];
                if(sum < 0) l++;
                else if(sum > 0 ) r--;
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    while(nums[l] == nums[l-1] && l < r){
                        l++;
                    }
                }
            }

        }

        return res;
    }
}
