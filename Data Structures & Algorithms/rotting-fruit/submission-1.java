class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                } else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int time = -1;

        while(!q.isEmpty()){
            int len = q.size();
            time++;
            for(int j=0; j<len ;j++){
                int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for(int i=0; i<dir.length; i++){
                int nr = r+dir[i][0], nc = c+dir[i][1];
                if(nr>=0 && nc >=0 && nr < row && nc < col && grid[nr][nc]==1){
                    grid[nr][nc] = 2;
                    q.add(new int[]{nr,nc});
                    fresh--;
                }
            }
            }
            
        }

        if(fresh==0) return time;
        return -1;
    }
}
