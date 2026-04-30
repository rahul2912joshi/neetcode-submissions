class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        ArrayList<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<cols; i++){
            dfs(heights, pacific, 0, i, heights[0][i]);
            dfs(heights, atlantic, rows-1, i, heights[rows-1][i]);
        }
        for(int i=0; i<rows; i++){
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, cols-1 , heights[i][cols-1]);
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    public void dfs(int[][] height, boolean[][] visited, int row, int col, int prevHeight){
        if(row<0||col<0||row>=height.length||col>=height[0].length) return;
        if(visited[row][col]) return;
        if(height[row][col] < prevHeight) return;

        visited[row][col]=true;
        dfs(height,visited,row+1,col,height[row][col]);
        dfs(height,visited,row-1,col,height[row][col]);
        dfs(height,visited,row,col+1,height[row][col]);
        dfs(height,visited,row,col-1,height[row][col]);
    }
}
