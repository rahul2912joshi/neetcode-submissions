class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board,word,visited,0,i,j)) return true;
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, boolean[][] visited, int pos, int row, int col){
        if(row >= board.length || col >= board[0].length || row<0 || col<0) return false;
        if(visited[row][col] == true || board[row][col] != word.charAt(pos)) return false;
        if(pos == word.length()-1) return true;

        visited[row][col] = true;
        boolean value =  backtrack(board,word,visited,pos+1,row-1,col) ||
                backtrack(board,word,visited,pos+1,row+1,col) ||
                backtrack(board,word,visited,pos+1,row,col-1) ||
                backtrack(board,word,visited,pos+1,row,col+1);
        visited[row][col] = false;
        return value;
    }
}
