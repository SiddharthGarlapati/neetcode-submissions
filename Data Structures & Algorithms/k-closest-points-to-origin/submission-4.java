class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int pivotIndex = n;
        int left = 0; int right = n - 1;

        while(pivotIndex != k){
            pivotIndex = partition(left,right,points);
            if(k < pivotIndex){
                right = pivotIndex - 1;
            }
            else{
                left = pivotIndex + 1;
            }
        }

        int[][] res = new int[k][2];

        for(int i = 0 ; i < k ; i++){
            res[i] = points[i];
        }

        return res;
    }

    private int partition(int left, int right, int[][] points){
        int index = left;

        for(int i = left ; i < right ; i++){
            if(euclidean(points[i]) <= euclidean(points[right])){
                swap(i,index,points);
                index++;
            }
        }

        swap(index, right, points);

        return index;
    }

    private void swap(int i, int j , int[][] points){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int euclidean(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
