class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int area = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == 1){
                    area = 1;
                    grid[r][c] = 0;
                    q.offer(new int[]{r,c});
                }

                while(!q.isEmpty()){
                    int[] curr = q.poll();
                    int row = curr[0];
                    int col = curr[1];

                    for(int[] dir: dirs){
                        int nRow = dir[0] + row;
                        int nCol = dir[1] + col;

                        if( nRow < 0 || nRow > rows - 1 || nCol < 0 || nCol > cols - 1 ||
                        grid[nRow][nCol] != 1){
                            continue;
                        }

                        area += 1;

                        grid[nRow][nCol] = 0;
                        q.offer(new int[]{nRow,nCol});

                    }

                }

                maxArea = Math.max(area, maxArea);

            }
        }

        return maxArea;
    }
}
