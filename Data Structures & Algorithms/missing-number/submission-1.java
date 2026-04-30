class Solution {
    public int missingNumber(int[] nums) {
        // long total = (long)((nums.length * (nums.length +1))/2);
        // long sum = 0;
        // for(int i=0; i<nums.length; i++){
        //     sum+=(long)nums[i];
        // }
        // return (int)(total-sum);
        // 0 1 2 3 4 6 7 8
        // 0 1 2 3 4 5 6 7

        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i] ^ i;
        }
        return xor ^ nums.length;
    }
}
