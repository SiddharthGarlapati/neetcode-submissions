class Solution {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        for(int c = 0 ;  c < cols; c++){
            if(board[0][c] == 'O'){
                dfs(0,c,board);
            }
            if(board[rows - 1][c] == 'O'){
                dfs(rows - 1 , c,board);
            }
        }

        for(int r = 0 ; r < rows ; r++){
            if(board[r][0] == 'O'){
                dfs(r,0,board);
            }
            if(board[r][cols - 1] == 'O'){
                dfs(r,cols - 1,board);
            }
        }

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
                if(board[r][c] == '#'){
                    board[r][c] = 'O';
                }

            }
        }
    }

    private void dfs(int r, int c, char[][] board){
        if(r < 0 || r > rows - 1 || c < 0 || c > cols - 1||
        board[r][c] == 'X' || board[r][c] == '#'){
            return;
        }

        board[r][c] = '#';
        dfs(r - 1,c,board);
        dfs(r + 1,c,board);
        dfs(r,c - 1,board);
        dfs(r,c + 1,board);
    }
}
