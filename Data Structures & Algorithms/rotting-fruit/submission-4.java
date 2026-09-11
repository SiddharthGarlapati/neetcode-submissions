class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        int fresh = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols ; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int minutes = 0;

        while(!q.isEmpty() && fresh > 0 ){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] temp = q.poll();
                int row = temp[0];
                int col = temp[1];
                for(int[] direction: directions){
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;

                    if(newRow >= 0 && newRow < rows && newCol >= 0 &&
                    newCol < cols && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        fresh--;
                        q.offer(new int[]{newRow,newCol});
                    }
                }
            }
            minutes++;
        }

        return (fresh == 0) ? minutes : -1;
        
    }
}
