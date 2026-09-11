class Solution {
    Map<Integer,Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = map.size();
        int[] unique = new int[n];
        int index = 0;

        for(int num : map.keySet()){
            unique[index] = num;
            index++;
        }

        int left = 0 ; 
        int right = n - 1;
        int target = n - k ; 

        while(left <= right){
            int pivotIndex = partition(left,right,unique);
            if(pivotIndex == target){
                break;
            }
            if(pivotIndex < target){
                left = pivotIndex + 1;
            }
            else{
                right = pivotIndex - 1;
            }
        }
        
        int[] res = new int[k];

        for(int i = target ; i < n ; i++){
            res[i - target] = unique[i];
        }

        return res;
    }

    private int partition(int left, int right , int[] unique){
        int index = left;
        int pivotCount = map.get(unique[right]);

        for(int i = left ; i < right ; i++){
            if(map.get(unique[i]) <  pivotCount){
                swap(i,index,unique);
                index++;
            }
        }

        swap(index,right,unique);

        return index;
    }

    private void swap(int i , int j , int[] unique){
        int temp = unique[i];
        unique[i] = unique[j];
        unique[j] = temp;
    }
}
