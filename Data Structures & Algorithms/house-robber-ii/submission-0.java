class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robNormal(nums, 0, nums.length-2), robNormal(nums,1,nums.length-1));
    }
    public int robNormal(int[] nums, int start, int end){
        int maxTillNow = 0, maxWithPrev = 0, maxWithoutPrev = 0;
        for(int i=start; i<=end; i++){
            maxTillNow = Math.max(maxWithPrev, maxWithoutPrev + nums[i]);
            maxWithoutPrev = maxWithPrev;
            maxWithPrev = maxTillNow;
        }
        return maxTillNow;
    }
}
