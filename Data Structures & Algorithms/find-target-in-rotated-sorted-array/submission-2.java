class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1){
            if(nums[0] == target) return 0;
            return -1;
        }
        int start=0, end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid] == target) return mid;
            else if(nums[end] >= nums[mid]){
                if(target <= nums[end] && target > nums[mid]){
                    start = mid+1;
                } else{
                    end = mid-1;
                }
            } else{
                if(target >= nums[start] && target < nums[mid]){
                    end = mid-1;
                } else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
