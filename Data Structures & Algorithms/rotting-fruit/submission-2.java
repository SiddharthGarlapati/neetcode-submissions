class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }
            }
        }

        int minutes = 0;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}}; 

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] temp = q.poll();
                int r = temp[0];
                int c = temp[1];
                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if( nr == rows || nr < 0 ||
                     nc == cols || nc < 0 || 
                     grid[nr][nc] != 1) continue;

                    q.offer(new int[]{nr,nc});
                    grid[nr][nc] = 2;
                    fresh--; 
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
