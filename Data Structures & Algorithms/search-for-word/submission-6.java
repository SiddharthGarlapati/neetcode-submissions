class Solution {
    int rows;
    int cols;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];

        for(int r = 0 ; r < rows; r++){
            for(int c = 0 ; c < cols ; c++){
                if(dfs(0,r,c,word, board)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int index, int r , int c , String word,char[][] board){
        if(index == word.length()){
            return true;
        }
        if(r < 0 || r > rows - 1 || c < 0 || c > cols - 1 || visited[r][c] == true || word.charAt(index) != board[r][c]){
            return false;
        }

        visited[r][c] = true;

        if(dfs(index + 1,r + 1, c,word,board) ||
        dfs(index + 1,r - 1, c,word,board) ||
        dfs(index + 1,r, c - 1,word,board) ||
        dfs(index + 1,r, c + 1,word,board)){
            return true;
        }

        visited[r][c] = false;

        return false;
    }
}
