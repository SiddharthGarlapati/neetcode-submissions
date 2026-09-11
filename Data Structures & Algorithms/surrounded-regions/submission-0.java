class Solution {
    int rows, cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        for( int r = 0 ; r < rows ; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O' && (r == 0 || c== 0 || 
                r == rows - 1 || c == cols -1)){
                    dfs(r,c,board);
                }
            }
        }

        for(int r = 0 ; r < rows; r++){
            for(int c = 0; c < cols ; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }

        for(int r = 0 ; r < rows; r++){
            for( int c = 0; c < cols; c++){
                if(board[r][c] == '#'){
                    board[r][c] = 'O';
                }
            }
        }

        
    }

    private void dfs(int r , int c , char[][] board){
        if(r < 0 || r == rows || c < 0 || c == cols 
        || board[r][c] != 'O') return;

        board[r][c] = '#';
        dfs(r + 1, c,board);
        dfs(r - 1, c,board);
        dfs(r, c - 1,board);
        dfs(r , c + 1,board);
    }
}
