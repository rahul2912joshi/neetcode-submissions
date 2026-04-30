class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowend=matrix.length-1;
        int colend=matrix[0].length-1;
        ArrayList<Integer> result = new ArrayList<>();
        int rowstart=0,colstart=0;
        while(rowstart<=rowend && colstart<=colend){
            for(int i=colstart;i<=colend;i++){
                result.add(matrix[rowstart][i]);
            }
            rowstart++;
            for(int i=rowstart;i<=rowend;i++){
                result.add(matrix[i][colend]);
            }
            colend--;
            if(rowstart>rowend) break;
            for(int i=colend;i>=colstart;i--){
                result.add(matrix[rowend][i]);
            }
            rowend--;
            if(colstart>colend) break;
            for(int i=rowend;i>=rowstart;i--){
                result.add(matrix[i][colstart]);
            }
            colstart++;
        }
        return result;
    }
}
