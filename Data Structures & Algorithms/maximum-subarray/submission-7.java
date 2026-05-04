class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return Integer.MIN_VALUE;
        int maxSum = nums[0];
        int currSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currSum = Math.max(nums[i],currSum + nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
            
    }
}

// 5 4 -1 7 8
