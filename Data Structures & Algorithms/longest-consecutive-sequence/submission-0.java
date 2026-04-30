class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            numbers.add(nums[i]);
        }
        int max = 0;
        for(int i=0; i<nums.length; i++){
            int len = 1;
            int k = nums[i];
            while(true){
                k++;
                if(numbers.contains(k)){
                    len++;
                } else break;
            }
            if(len > max) max = len;
        }
        return max;
    }
}
