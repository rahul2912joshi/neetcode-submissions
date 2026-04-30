class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxlen = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int[] len = new int[]{0};
                if(grid[i][j]==1){
                    dfs(grid, i, j, len);
                }
                maxlen = Math.max(maxlen,len[0]);
            }
        }
        return maxlen;
    }

    public void dfs(int[][] grid, int row, int col, int[] len){
        if(row<0 || col<0||row>=grid.length||col>=grid[0].length || grid[row][col]==0) return;
        len[0]++;
        grid[row][col]=0;
        dfs(grid,row+1,col,len);
        dfs(grid,row-1,col,len);
        dfs(grid,row,col-1,len);
        dfs(grid,row,col+1,len);
    }
}
