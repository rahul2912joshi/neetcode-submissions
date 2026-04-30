class Solution {
    public void rotate(int[][] matrix) {
        int start=0, end=matrix.length-1;
        while(start<end){
            for(int i=0; i<matrix[0].length;i++){
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
            start++;
            end--;
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
// mat[i][j] -> mat[][]
// 0 1 -> 1 0
// 1 0 -> 0 1

// 3 4
// 1 2
// 3 1
// 4 2
//