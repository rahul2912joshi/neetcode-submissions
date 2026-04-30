/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length()-1;
        int peak = -1;

        while(left < right){
            int mid = left + (right-left)/2;
            int midVal = mountainArr.get(mid);
            int rightVal = mountainArr.get(mid+1);
            if(midVal < rightVal){
                left = mid+1;
            } else{
                right = mid;
            }
        }
        peak = left;
        // 0 5 3 1
        int len = mountainArr.length()-1;
        int peakVal = mountainArr.get(peak);
        boolean inc = true;
        
        int res = search(mountainArr, target, 0, peak, inc);
        if(res != -1) return res;
        return search(mountainArr, target, peak+1, len, !inc);
    }

    public int search(MountainArray mountainArr, int target, int left, int right, boolean inc){
        while(left<=right){
            int mid = left + (right-left)/2;
            int midVal = mountainArr.get(mid);

            if(midVal == target) return mid;
            if(target < midVal){
                if(inc){
                    right = mid-1;
                } else{
                    left = mid+1;
                }
            } else{
                if(inc){
                    left = mid+1;
                } else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
// 5 6 5 4 3
