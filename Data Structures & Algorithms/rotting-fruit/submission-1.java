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

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] temp = q.poll();
                int r = temp[0];
                int c = temp[1];
                if( r+1 < rows && grid[r+1][c] == 1){
                    q.offer(new int[]{r+1,c});
                    grid[r+1][c] = 2;
                    fresh--;
                }
                if( r-1 >=0 && grid[r - 1][c] == 1){
                    q.offer(new int[]{r-1,c});
                    grid[r-1][c] = 2;
                    fresh--;
                }
                if( c+1 < cols && grid[r][c+1] == 1){
                    q.offer(new int[]{r,c+1});
                    grid[r][c+1] = 2;
                    fresh--;
                }
                if( c-1 >= 0 && grid[r][c-1] == 1){
                    q.offer(new int[]{r,c-1});
                    grid[r][c-1] = 2;
                    fresh--;
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
