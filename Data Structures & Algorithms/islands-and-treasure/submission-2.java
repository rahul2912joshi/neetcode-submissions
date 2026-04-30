class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid.length==0) return;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0; i<4; i++){
                int nrow = curr[0]+dirs[i][0];
                int ncol = curr[1]+dirs[i][1];

                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol <grid[0].length && grid[nrow][ncol] == Integer.MAX_VALUE){
                    grid[nrow][ncol] = grid[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{nrow,ncol});
                }
            }
        }
        return;
    }
}
