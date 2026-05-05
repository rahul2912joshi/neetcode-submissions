class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int maxIncludingPrev = 0;
        int maxExcludingPrev = 0;

        for(int i=0; i<nums.length; i++){
            int temp = maxIncludingPrev;
            maxIncludingPrev = nums[i]+maxExcludingPrev;
            maxExcludingPrev = Math.max(temp, maxExcludingPrev);
        }
        return Math.max(maxIncludingPrev,maxExcludingPrev);
    }
}

// 5,1,2,10,6,2,7,9,3,1
// 5 0, 1 5, 7 
// inc 7
// exc 1
// temp 1
 