class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int maxwiththis = nums[0];
        int maxwithoutthis = 0;
        int max = nums[0];

        for(int i=1; i<nums.length; i++){
            maxwiththis = maxwithoutthis + nums[i];
            maxwithoutthis = max;
            max = Math.max(max, Math.max(maxwithoutthis, maxwiththis));
        }
    return max;
    }
}
