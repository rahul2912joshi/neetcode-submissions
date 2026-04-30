class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int start=0, end=nums.length-1;
        while(start<end){
            if(nums[start] <= nums[end]) return nums[start];
            int mid = start + (end-start)/2;
            if((nums[mid+1] <= nums[end]) && (nums[start] <= nums[mid])) return nums[mid+1];
            if(nums[mid+1] <= nums[end]) end = mid;
            else start = mid+1;
        }
        return -1;
    }
}
