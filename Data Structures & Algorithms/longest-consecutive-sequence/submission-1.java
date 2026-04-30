class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            numbers.add(nums[i]);
        }
        int max = 0;
        for(int i=0; i<nums.length; i++){
            if(numbers.contains(nums[i]-1)) continue;
            int len = 1;
            int k = nums[i];
            while(numbers.contains(k+1)){
                k++;
                len++;
            }
            if(len > max) max = len;
        }
        return max;
    }
}
