class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      int top = 0 ;
      int bottom = matrix.length - 1;
      int left = 0;
      int right = matrix[0].length - 1;
      List<Integer> res = new ArrayList<>();

      while(left <= right && top <= bottom){

        for(int col = left; col <= right; col++ ){
            res.add(matrix[top][col]);
        }

        top++;

        for(int row = top ; row <= bottom ; row++){
            res.add(matrix[row][right]);
        }

        right--;


        if(!(left <= right && top <= bottom)){
            break;
        }

        for(int col = right; col >= left; col--){
            res.add(matrix[bottom][col]);
        }

        bottom--;

        for(int row = bottom; row >= top ; row--){
            res.add(matrix[row][left]);
        }

        left++;



      }

      return res;

    }
}
