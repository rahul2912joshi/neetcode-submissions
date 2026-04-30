class Solution {
    public int missingNumber(int[] nums) {
        long total = (long)((nums.length * (nums.length +1))/2);
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=(long)nums[i];
        }
        return (int)(total-sum);
    }
}
