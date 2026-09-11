class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l1 = 0 , r1 = m - 1;
        int row = -1;

        while( l1 <= r1){
            int mid = l1 + (r1 - l1)/2;
            if(target <= matrix[mid][n - 1]){
                if(target >= matrix[mid][0]){
                    row = mid;
                    break;
                }
                else{
                    r1 = mid - 1;
                }

            }
            else{
                l1 = mid + 1;
            }

        }


        int l2 = 0 , r2 = n - 1;

        if(row >= 0){
            while(l2 <= r2){
                int mid = l2 + (r2 - l2)/2;
                if(target == matrix[row][mid]){
                    return true;
                }
                if(target < matrix[row][mid]){
                    r2 = mid - 1;
                }
                else{
                    l2 = mid + 1;
                }
            }

            return false;

        }

        return false;
        


        
    }
}
