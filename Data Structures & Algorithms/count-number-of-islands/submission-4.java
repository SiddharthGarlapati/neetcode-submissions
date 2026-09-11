class Solution {
    int rows;
    int cols;
    public int numIslands(char[][] grid) {

        int islands = 0;
        rows = grid.length;
        cols = grid[0].length;

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == '1'){
                    islands++;
                    dfs(r,c,grid);
                }
            }
        }

        return islands;
        
    }

    private void dfs(int r , int c, char[][] grid){
        if(r < 0 || r > rows - 1 || c < 0 || c > cols - 1 ||
        grid[r][c] != '1'){
            return;
        }

        grid[r][c] = '0';
        dfs(r + 1 , c , grid);
        dfs(r - 1 , c, grid);
        dfs(r, c - 1, grid);
        dfs(r, c + 1, grid);
    }
}
