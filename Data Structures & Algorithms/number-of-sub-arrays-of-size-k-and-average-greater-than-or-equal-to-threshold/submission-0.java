class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int sum = 0;
        int count = 0;

        for(int i = 0; i < k ; i++){
            sum += arr[i];
        }

        if(sum / k  >= threshold){
            count++;
        }

        int left = 0;
        for(int right = k ; right < n ; right++){
            sum += arr[right];
            sum -= arr[left];
            left++;

            if(sum / k >= threshold){
                count++;
            }
        }

        return count;
    
        
    }
}