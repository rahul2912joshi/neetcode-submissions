class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int maxInclude = 0;
        int maxExclude = 0;

        for(int i=0; i<nums.length-1; i++){
            int temp = maxInclude;
            maxInclude = nums[i]+maxExclude;
            maxExclude = Math.max(temp, maxExclude);
        }

        int max1 = Math.max(maxInclude, maxExclude);
        maxInclude = 0;
        maxExclude = 0;
        for(int i=nums.length-1; i>0; i--){
            int temp = maxInclude;
            maxInclude = nums[i]+maxExclude;
            maxExclude = Math.max(temp, maxExclude);
        }
        int max2 = Math.max(maxInclude, maxExclude);
        return Math.max(max1,max2);
    }
}

// 2 9 8 3 6
// 2 0, 9 2, 10 9, 12 10
// 6 0, 3 6, 14 6, 15 14

// 9 8 3
// 