class Solution {
    public int swimInWater(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[] {grid[0][0],0,0});
        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int t = curr[0];
            int r = curr[1];
            int c = curr[2];

            visited[r][c] = true;

            if(r == rows - 1 && c == cols - 1) return t;

            for(int[] direction: directions){
                int nr = r + direction[0];
                int nc = c + direction[1];

                if(nr < 0 || nc < 0 || nr == rows || nc == cols || visited[nr][nc]) continue;

                minHeap.offer(new int[] {Math.max(t,grid[nr][nc]),nr,nc});

            }

        }

        return -1;

        
    }
}
