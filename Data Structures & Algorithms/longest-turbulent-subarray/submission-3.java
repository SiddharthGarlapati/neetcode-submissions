class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int n = arr.length;
        int left = 0;
        int right = 1;
        int prev = 0;
        int maxLen = 1;

        while( right < n){
            if(arr[right - 1] > arr[right] && prev != 1 ){
                maxLen = Math.max(maxLen, right - left + 1);
                prev = 1;
                right++;
            }
            else if( arr[right - 1] < arr[right] && prev != -1){
                maxLen = Math.max(maxLen, right - left + 1);
                prev = -1;
                right++;
            }
            else{
                if(arr[right - 1] == arr[right]){
                    left = right;
                    right++;
                }
                else{
                    left = right - 1;
                }
                prev = 0;
            }

        }

        return maxLen;
        
    }
}