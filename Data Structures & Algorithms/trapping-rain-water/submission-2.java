class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxL = height[0];
        int maxR = height[n-1];
        int ans = 0;

        while(l < r){
            if(maxL < maxR){
                l++;
                maxL = Math.max(maxL,height[l]);
                ans += maxL - height[l];
            }
            else{
                r--;
                maxR = Math.max(maxR,height[r]);
                ans += maxR - height[r];
            }    
        }

        return ans;

        
    }
}
