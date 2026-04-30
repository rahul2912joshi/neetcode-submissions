class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int maxTillNow = 0;
        for(int i=0; i<nums.length; i++){
            maxTillNow+=nums[i];
            maxSum = Math.max(maxSum,maxTillNow);
            if(maxTillNow<=0){
                maxTillNow = 0;
            }
        }
        return maxSum;
    }
}

// 2 -3 4 -2 2 1 -1 4
// 8
// 8
