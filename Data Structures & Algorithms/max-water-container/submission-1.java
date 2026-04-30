class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1, max = 0;

        while(left<right){
            int water = (right-left)*Math.min(heights[left],heights[right]);
            max = Math.max(max, water);
            if(heights[left] < heights[right]) left++;
            else right--;
        }
        return max;
    }
}
