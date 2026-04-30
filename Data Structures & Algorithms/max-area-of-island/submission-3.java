class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if(grid.length==0) return maxArea;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    int[] area = new int[]{0};
                    dfs(grid,area,i,j);
                    if(area[0]>maxArea) maxArea=area[0];
                }
            }
        }
        return maxArea;
    }

    public void dfs(int[][]grid, int[] area, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return;
        grid[i][j]=0;
        area[0]++;
        dfs(grid,area,i-1,j);
        dfs(grid,area,i+1,j);
        dfs(grid,area,i,j-1);
        dfs(grid,area,i,j+1);
    }
}
