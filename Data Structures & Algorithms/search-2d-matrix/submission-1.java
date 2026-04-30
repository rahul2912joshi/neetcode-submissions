class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        if(target < matrix[0][0] || target > matrix[row-1][col-1]) return false;
        int start = 0, end = row-1;
        int targetrow = -1;
        while(start<=end){
            int mid = (end-start)/2 + start;
            if(matrix[mid][0] <= target && target <= matrix[mid][col-1]){
                targetrow = mid;
                break;
            }
            if(matrix[mid][0] > target){
                end=mid-1;
            } else {
                start = mid+1;
            }
        }
        if(targetrow==-1) return false;
        start = 0; end=col-1;
        while(start<=end){
            int mid = (end-start)/2 + start;
            if(matrix[targetrow][mid] == target){
                return true;
            }
            if(matrix[targetrow][mid] > target){
                end=mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
