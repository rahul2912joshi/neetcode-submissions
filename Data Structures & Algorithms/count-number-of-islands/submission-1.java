class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    fill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void fill(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        fill(grid,i-1,j);
        fill(grid,i+1,j);
        fill(grid,i,j-1);
        fill(grid,i,j+1);
    }
}
