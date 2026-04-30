class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;

        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }

    public void reverse(int[] nums, int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
// 8 7 6 5 4 3 2 1
// 5 6 7 8 1 2 3 4

// 8 1 2 3 4 5 6 7
// 4 5 6 7 8 1 2 3