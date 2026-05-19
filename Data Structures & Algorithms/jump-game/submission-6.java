class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        if(nums.length==0) return false;
        for(int i=0; i<nums.length; i++){
            if(i>maxIndex) return false;
            int jump = nums[i];
            maxIndex = Math.max(maxIndex, i+jump);
        }
        return true;
    }
}
