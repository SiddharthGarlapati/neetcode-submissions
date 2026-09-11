class Solution {
    public int maxArea(int[] heights) {

        int left = 0 ; 
        int right = heights.length - 1;
        int res = 0;

        while(left < right){
            int cur_res = (right - left) * Math.min(heights[right],heights[left]);
            res = Math.max(cur_res,res);
            if(heights[right] > heights[left]){
                left++;
            }
            else{
                right--;
            }


        }

        return res;
        
    }
}
