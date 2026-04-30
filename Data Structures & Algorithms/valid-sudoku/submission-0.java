class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        boolean isValid = true;
        for(int i=0; i<n; i++){
            isValid &= rowvalid(board, i, n);
            if (isValid==false) return false;
        }
        for(int i=0; i<n ;i++){
            isValid &= colvalid(board, i, n);
            if (isValid==false) return false;
        }
        for(int i=0; i<n; i=i+3){
            for(int j=0; j<n ;j=j+3){
                isValid &= gridvalid(board, i, j);
                if(isValid==false) return false;
            }
        }
        return true;   
    }
    public boolean rowvalid(char[][] board, int row, int n){
        HashSet<Character> freq = new HashSet<>();
        for(int i=0; i<n; i++){
            char num = board[row][i];
            if(num != '.' && freq.contains(num)) return false;
            freq.add(num);
        }
        return true;
    }
    public boolean colvalid(char[][] board, int col, int n){
        HashSet<Character> freq = new HashSet<>();
        for(int i=0; i<n; i++){
            char num = board[i][col];
            if(num != '.' && freq.contains(num)) return false;
            freq.add(num);
        }
        return true;
    }
    public boolean gridvalid(char[][] board, int row, int col){
        HashSet<Character> freq = new HashSet<>();
        for(int i=row; i<row+3; i++){
            for(int j=col; j<col+3; j++){
                char num = board[i][j];
                if(num != '.' && freq.contains(num)) return false;
                freq.add(num);
            }
        }
        return true;
    }
    
}
