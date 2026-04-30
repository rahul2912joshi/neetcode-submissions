class Solution {
    public int removeElement(int[] nums, int val) {
        int insert = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[insert] = nums[i];
                insert++;
            }
        }
        return insert;
    }
}
//nums=[0,1,2,2,3,0,4,2]
//count = 1
//val=2