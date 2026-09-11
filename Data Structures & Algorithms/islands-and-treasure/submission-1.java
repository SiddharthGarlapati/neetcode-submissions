class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int INF = 2147483647;

        Queue<int[]> q = new ArrayDeque<>();

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int r = 0 ; r < rows; r++){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == 0){
                    q.offer(new int[]{r,c});
                }
            }
        }

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int row = temp[0];
            int col = temp[1];

            for(int[] dir : dirs){
                int newR = dir[0] + row;
                int newC = dir[1] + col;

                if( newR < 0  || newR >= rows ||
                newC < 0 || newC >= cols || grid[newR][newC] != INF){
                    continue;
                }

                grid[newR][newC] = grid[row][col] + 1;
                q.offer(new int[]{newR,newC}); 
            }
        }

        
    }
}
