class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length==1) return nums.length;
        int pos = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}