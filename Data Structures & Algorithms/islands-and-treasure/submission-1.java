class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0) q.offer(new int[]{i,j,0});
            }
        }

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int value = curr[2];
                if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==-1){
                    continue;
                } else if(grid[x][y]==0){
                    q.offer(new int[]{x-1,y,grid[x][y]});
                    q.offer(new int[]{x+1,y,grid[x][y]});
                    q.offer(new int[]{x,y-1,grid[x][y]});
                    q.offer(new int[]{x,y+1,grid[x][y]});
                } else if(grid[x][y]==Integer.MAX_VALUE){
                    grid[x][y] = (value+1);
                    q.offer(new int[]{x-1,y,grid[x][y]});
                    q.offer(new int[]{x+1,y,grid[x][y]});
                    q.offer(new int[]{x,y-1,grid[x][y]});
                    q.offer(new int[]{x,y+1,grid[x][y]});
                }
            } 
        }
        return;
    }
}
