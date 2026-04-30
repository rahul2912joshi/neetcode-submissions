class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int colstart = 0, rowstart=0, colend=matrix[0].length-1, rowend=matrix.length-1;
        ArrayList<Integer> result = new ArrayList<>();
        while(colstart<=colend && rowstart<=rowend){
            for(int i=colstart ; i<=colend; i++){
                result.add(matrix[rowstart][i]);
            }
            rowstart++;
            for(int i=rowstart ; i<=rowend; i++){
                result.add(matrix[i][colend]);
            }
            colend--;
            if(rowstart<=rowend){
            for(int i=colend ; i>=colstart; i--){
                result.add(matrix[rowend][i]);
            }}
            rowend--;
            if(colstart<=colend){
            for(int i=rowend ; i>=rowstart; i--){
                result.add(matrix[i][colstart]);
            }}
            colstart++;
        }
        return result;
    }
}
