class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstrow=false, firstcol= false;

            for(int i=0; i<col; i++){
                if(matrix[0][i] == 0) firstrow = true;
            }
            for(int i=0; i<row; i++){
                if(matrix[i][0] == 0) firstcol = true;
            }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstrow){
            for(int i=0; i<col; i++){
                matrix[0][i]=0;
            }
        }
        if(firstcol){
            for(int i=0; i<row; i++){
                matrix[i][0]=0;
            }
        } 
    }
}

/*
0 2 3
1 1 1
1 2 0

0 2 0
1 1 1
0 2 0

0 2 0
1 1 1
0 0 0

0 0 0
0 1 0
0 0 0
*/
