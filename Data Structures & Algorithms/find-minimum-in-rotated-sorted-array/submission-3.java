class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int start=0, end=nums.length-1;
        while(start<=end){
            if(nums[start] < nums[end]) return nums[start];
            int mid= start+(end-start)/2;
            if( mid!=0 && nums[mid]<nums[mid-1]) return nums[mid];
            if(nums[start]<=nums[mid]) start=mid+1;
            else end=mid-1;
        }
        return -1;
    }
}
