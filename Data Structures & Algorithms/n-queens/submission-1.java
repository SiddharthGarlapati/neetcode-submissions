class Solution {
    List<List<String>> res;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row , '.');
        }
        int rows = n;


        dfs(0,n);

        return res;
    }

    private void dfs(int r , int n){
        if(r == n){
            res.add(buildBoard());
            return;
        }

        for(int c = 0 ; c < n ; c++){
            if(isSafe(r,c,n)){
                board[r][c] = 'Q';
                dfs(r + 1 , n);
                board[r][c] = '.';
            }
        }
    }

    private boolean isSafe(int r, int c, int n){
        for(int row = 0 ; row < r ; row++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }    

        int row = r - 1;
        int col = c - 1;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }


        row = r - 1;
        col = c + 1;

        while(row >= 0 && col < n){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col++;
        }

        return true;
        
    }

    private List<String> buildBoard(){
        List<String> list = new ArrayList<>();
        for(char[] row: board){
            list.add(new String(row));
        }

        return list;
    }

    
}
