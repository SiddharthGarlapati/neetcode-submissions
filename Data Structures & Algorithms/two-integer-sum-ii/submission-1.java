class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;

        while(left < right){
            int cur_sum = numbers[left] + numbers[right];

            if(cur_sum > target){
                right--;
            }
            else if(cur_sum < target){
                left++;
            }
            else{
                return new int[]{left+1, right+1};
            }
        }

        return new int[]{};

    }
}
