class Solution {

    List<List<Integer>> result;
    boolean[][] pacific;
    boolean[][] atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        pacific = new boolean[rows][cols];
        atlantic = new boolean[rows][cols];

        result = new ArrayList<>();

        for(int c = 0 ; c < cols; c++){
            dfs(0, c, pacific,heights[0][c],heights);
            dfs(rows - 1, c , atlantic,heights[rows - 1][c],heights);
        }

        for(int r = 0 ; r < rows ; r++){
            dfs(r,0,pacific,heights[r][0],heights);
            dfs(r,cols - 1, atlantic, heights[r][cols - 1],heights);
        }


        for( int r = 0 ; r < rows; r++){
            for(int c = 0 ; c < cols ; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(r);
                    temp.add(c);
                    result.add(temp);
                }
            }
        }

        return result;
        
    }


    private void dfs(int r , int c ,boolean[][] visited,  int prevHeight, int[][] heights){

        if( r < 0 || c < 0 || r == heights.length || c == heights[0].length 
        || visited[r][c] == true || heights[r][c] < prevHeight){
            return ;
        }

        visited[r][c] = true;

        dfs(r - 1,c, visited, heights[r][c], heights);
        dfs(r + 1,c , visited, heights[r][c], heights);
        dfs(r,c - 1,  visited, heights[r][c], heights);
        dfs(r,c + 1, visited, heights[r][c], heights);
        
    }
}
