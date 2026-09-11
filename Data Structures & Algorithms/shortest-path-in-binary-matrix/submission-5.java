class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n - 1][n - 1] != 0){
            return -1;
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

        int path = 1;

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                if( r == n -1 && c == n - 1){
                    return path;
                }

                for(int[] dir : directions){
                    int newR = dir[0] + r;
                    int newC = dir[1] + c;

                    if(newR < 0 || newR > n - 1 || newC < 0 || newC  > n - 1 ||
                    grid[newR][newC] != 0){
                        continue;
                    }
                    grid[newR][newC] = 1;
                    q.offer(new int[]{newR,newC});
                }                

            }
            path++;
        }

        return -1;
        
    }
}