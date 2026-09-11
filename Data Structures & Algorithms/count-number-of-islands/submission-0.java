class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;
        for(int r = 0 ; r < rows; r++){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == '1'){
                   numIslands++;
                   dfs(r,c,grid);
                }

            }
        }

        return numIslands;
        
    }

    private void dfs(int r , int c, char[][] grid){
        if(r < 0 || c < 0 || r >= grid.length ||
         c >= grid[0].length || grid[r][c] == '0'){
            return ;
         }

         grid[r][c] = '0';
         dfs(r - 1 ,c, grid);
         dfs(r + 1,c, grid);
         dfs(r,c - 1, grid);
         dfs(r,c + 1, grid);

    }
}
