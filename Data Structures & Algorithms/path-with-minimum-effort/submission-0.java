class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] visited = new boolean [rows][cols];
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> (a[0] - b[0]));
        minHeap.offer(new int[]{0,0,0});

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int maxDiff = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            if(visited[r][c]){
                continue;
            }

            visited[r][c] = true;

            if(r == rows - 1 && c == cols - 1){
                return maxDiff;
            }

            for(int[] dir : directions){
                int newR = dir[0] + r;
                int newC = dir[1] + c;

                if(newR < 0 || newR > rows - 1 || newC < 0 || newC > cols - 1 ||
                visited[newR][newC]){
                    continue;
                }

                int diff = Math.max(maxDiff, Math.abs(heights[r][c] - heights[newR][newC]));
                minHeap.offer(new int[]{diff, newR,newC});
            }
        }

        return -1;
    }
}