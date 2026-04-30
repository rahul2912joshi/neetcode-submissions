class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid.length==0 || grid.length==1) return;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int row = curr[0], col=curr[1];
            for(int i=0; i<directions.length; i++){
                int r = row+directions[i][0];
                int c = col + directions[i][1];

                if(r<0 || c<0||r>=grid.length||c>=grid[0].length||grid[r][c]!=Integer.MAX_VALUE) continue;
                grid[r][c] = grid[row][col]+1;
                q.add(new int[]{r,c});
            }
        }
    }
}
