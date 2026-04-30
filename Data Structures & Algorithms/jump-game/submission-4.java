class Solution {
    public boolean canJump(int[] nums) {
        int maxreach = 0;
        int i=0;
        while(i<=maxreach){
            if(i==nums.length-1) return true;
            maxreach = Math.max(maxreach,nums[i]+i);
            i++;
        }
        return false;
    }
}
