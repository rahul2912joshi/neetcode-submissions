class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    count++;
                    calculate(grid,i-1,j);
                    calculate(grid,i,j-1);
                    calculate(grid,i,j+1);
                    calculate(grid,i+1,j);
                }
            }
        }
        return count;
    }
    public void calculate(char[][] grid, int i, int j){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length) return;
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            calculate(grid,i-1,j);
            calculate(grid,i,j-1);
            calculate(grid,i,j+1);
            calculate(grid,i+1,j);
        }
    }
}
