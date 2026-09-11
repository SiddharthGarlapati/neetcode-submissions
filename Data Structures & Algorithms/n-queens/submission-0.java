class Solution {

    char[][] board;
    List<List<String>> res;
    int rows;
    int cols;

    public List<List<String>> solveNQueens(int n) {
        rows = n;
        cols = n;

        board = new char[n][n];
        res = new ArrayList<>();

        for(int row = 0 ; row < n ; row++){
            Arrays.fill(board[row],'.');
        }

        backtrack(0);

        return res;
    }

    public void backtrack(int row){
        if(row == rows){
            buildboard();
            return;
        }

        for(int col = 0; col < cols; col++){
            if(isSafe(row,col)){
                board[row][col] = 'Q';
                backtrack(row + 1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col){
        for( int r = 0; r < row; r++){
            if(board[r][col] == 'Q') return false;
        }

        for(int r = row - 1, c = col - 1; r>=0 && c>=0; r-- , c--){
            if(board[r][c] == 'Q') return false;
        }

        for(int r = row - 1, c = col + 1; r>=0 && c < cols; r--, c++ ){
            if(board[r][c] == 'Q') return false;
        }

        return true;

    }

    public void buildboard(){
        List<String> temp = new ArrayList<>();

        for(int r = 0 ; r < rows; r++){
            temp.add(new String(board[r]));
        }

        res.add(temp);

    }
}
