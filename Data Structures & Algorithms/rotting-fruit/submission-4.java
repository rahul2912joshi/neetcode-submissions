class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0) return -1;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2) q.offer(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int result = 0;

        while(!q.isEmpty()){
            int levelLen = q.size();
            int rotted = 0;
            for(int j=0; j<levelLen; j++){
                int[] curr = q.poll();
                
                int row = curr[0], col = curr[1];
                for(int i=0; i<dirs.length; i++){
                    int nrow = row + dirs[i][0];
                    int ncol = col + dirs[i][1];

                    if(nrow>=0&&ncol>=0&&nrow<grid.length&&ncol<grid[0].length&&grid[nrow][ncol]==1){
                        fresh--;
                        rotted++;
                        grid[nrow][ncol]=2;
                        q.offer(new int[]{nrow,ncol});
                    }
                }
            }
            if(rotted!=0) result++;
        }
        return (fresh==0) ? result:-1;
    }
}
