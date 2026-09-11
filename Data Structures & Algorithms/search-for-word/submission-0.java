class Solution {
    private int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for( int r = 0 ; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(dfs(board,r,c,0,word)) return true;
            }
        }

        return false;
        
    }

    private boolean dfs(char[][] board, int r, int c, int i ,String word){
        if(i == word.length()){
            return true;
        }
        if( r < 0 || c < 0 || r >= rows || c >= cols || 
        word.charAt(i) != board[r][c] || board[r][c] == '#' ){
            return false;
        }

        board[r][c] = '#';
        boolean res = (dfs(board, r + 1, c,i+1, word) ||
                       dfs(board, r - 1, c,i+1, word) ||
                       dfs(board, r, c + 1,i+1, word) ||
                       dfs(board, r, c - 1,i+1, word) );
        board[r][c] = word.charAt(i);

        return res;               
    }
}
