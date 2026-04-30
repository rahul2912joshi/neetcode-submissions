class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(count==0) maj = nums[i];
            if(nums[i] == maj) count++;
            else{
                count--;
            }
        }
        return maj;
    }
}
// only integers?
// empty array?
// solution is always possible?
// 1 3 4 2 2 2 2