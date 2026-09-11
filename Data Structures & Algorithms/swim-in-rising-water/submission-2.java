class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> ( a[0] - b[0]));
        minHeap.offer(new int[]{grid[0][0],0,0});

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int maxHeight = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(visited[r][c]){
                continue;
            }

            visited[r][c] = true;

            if(r == rows - 1 && c == cols - 1){
                return maxHeight;
            }


            for(int[] direction: directions){
                int newR = direction[0] + r;
                int newC = direction[1] + c;

                if(newR < 0 || newR > rows - 1 || newC < 0 || newC > cols - 1 || visited[newR][newC] == true ){
                    continue;
                }

                minHeap.offer(new int[]{Math.max(maxHeight,grid[newR][newC]),newR,newC});
            }
        }

        return -1;

    }
}
