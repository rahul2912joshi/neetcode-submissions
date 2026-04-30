class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m+n-1, right1 = m-1, right2 = n-1;
        while(right1 >= 0 && right2 >= 0){
            if(nums1[right1] >= nums2[right2]){
                nums1[pos--] = nums1[right1--];
            } else{
                nums1[pos--] = nums2[right2--];
            }
        }
        while(right2 >= 0){
            nums1[pos--] = nums2[right2--];
        }
    }
}