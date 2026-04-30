class Solution {
    public int rob(int[] nums) {
        int incPrev = nums[0];
        int noPrev = 0;

        for(int i=1; i<nums.length; i++){
            int curr = noPrev + nums[i];
            noPrev = Math.max(incPrev,noPrev);
            incPrev = curr;
        }
        return Math.max(incPrev,noPrev);
    }
}
// incPrev 16
// noPrev 12
// current 16
// max= 16
