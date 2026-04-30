class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int jump = 0;
        int end = 0;

        int maxIndex = 0;
        for(int i=0; i<nums.length-1; i++){
            maxIndex = Math.max(maxIndex,i+nums[i]);
            if(i==end){
                jump++;
                end = maxIndex;
            }
        }
        return jump;
    }
}
// 2 4 1 1 1 1
// 2
// 
