class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if( i > 0 && nums[i] == nums[i-1]) continue;
                int left = i+1;
                int right = n-1;

                while(left < right){
                    int cur_sum = nums[i] + nums[left] + nums[right];

                    if(cur_sum < 0){
                        left++;
                    }
                    else if (cur_sum > 0){
                        right--;
                    }
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }
                }


        }

        return result;

        
    }
}
