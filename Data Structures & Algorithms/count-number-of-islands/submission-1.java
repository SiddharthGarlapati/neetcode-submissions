class Solution {
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int numOfIslands = 0;

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == '1'){
                    numOfIslands++;
                    dfs(r,c,grid);
                }
            }
        }
        
        return numOfIslands;
    }

    private void dfs(int r , int c, char[][] grid){
        if(r < 0 || r > rows - 1 || c < 0 || c > cols - 1 ||
        grid[r][c] != '1'){
            return;
        }

        grid[r][c] = '0';

        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }
}
