class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int n = arr.length;
        int left = 0;
        int right = 1;
        String prev = "";
        int maxLen = 1;

        while( right < n){
            if(arr[right - 1] > arr[right] && !prev.equals(">")){
                maxLen = Math.max(maxLen, right - left + 1);
                prev = ">";
                right++;
            }
            else if( arr[right - 1] < arr[right] && !prev.equals("<")){
                maxLen = Math.max(maxLen, right - left + 1);
                prev = "<";
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
                prev = "";
            }

        }

        return maxLen;
        
    }
}