class Solution {
    boolean[][] visited;
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ;  c < cols ; c++){
                if(dfs(0,r,c,board, word)){
                    return true;
                }
            }
        }

        return false;

    }

    private boolean dfs(int i , int r , int c, char[][] board, String word){
        if( i == word.length()){
            return true;
        }
        if(r < 0 || r > rows - 1 || c < 0 ||
        c > cols - 1 || visited[r][c] == true){
            return false;
        }

        if(word.charAt(i) == board[r][c]){
            visited[r][c] = true;
            if(dfs(i + 1,r ,c - 1, board, word) || dfs(i + 1,r , c + 1, board, word)
             || dfs(i + 1,r - 1 , c , board, word) || dfs(i + 1,r + 1, c, board, word)){
                return true;
            }   
            visited[r][c] = false;         
        }

        return false;
    }
}
