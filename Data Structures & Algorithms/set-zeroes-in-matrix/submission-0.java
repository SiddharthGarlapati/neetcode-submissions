class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean row0 = false;
        boolean col0 = false;

        for(int r = 0 ; r < rows; r++){
            if(matrix[r][0] == 0){
                col0 = true;
                break;
            }
        }

        for(int c = 0 ; c < cols ; c++){
            if(matrix[0][c] == 0){
                row0 = true;
                break;
            }
        }

        for(int r = 1 ; r < rows; r++){
            for(int c = 1; c < cols ; c++){
                if(matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for(int r = 1 ; r < rows; r++){
            for(int c = 1 ; c < cols; c++){
                if(matrix[r][0] == 0 || matrix[0][c] == 0){
                    matrix[r][c] = 0;
                }
            }
        }

        if(row0){
            for(int c = 0; c < cols ; c++ ){
                matrix[0][c] = 0;
            }
        }

        if(col0){
            for( int r = 0 ; r < rows ; r++){
                matrix[r][0] = 0;
            }
        }


    }
}
