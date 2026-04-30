class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[Math.abs(nums[i])] < 0) return Math.abs(nums[i]);
            nums[Math.abs(nums[i])] = -1*nums[Math.abs(nums[i])];
        }
        return Math.abs(nums[0]);

        // int fast = nums[0];
        // int slow = nums[0];

        // fast = nums[nums[fast]];
        // slow = nums[slow];

        // while(fast!=slow){
        //     fast = nums[nums[fast]];
        //     slow = nums[slow];
        // }

        // slow = nums[0];
        // while(slow!=fast){
        //     slow = nums[slow];
        //     fast = nums[fast];
        // }
        // return slow;
    }
}
