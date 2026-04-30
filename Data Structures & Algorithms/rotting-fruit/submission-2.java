class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0) return 0;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]==2) q.offer(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;

        int time = 0;
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int len = q.size();
            boolean rotted = false;
            for(int i=0; i<len; i++){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for(int[] dir : direction){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length || grid[nx][ny]==0) continue;
                    if(grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        q.offer(new int[]{nx,ny});
                        fresh--;
                        rotted = true;
                    }
                }
            }  
            if(rotted) time++; 
        }
        return fresh==0?time:-1;
    }
}
