class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for(int i=1; i<nums.length; i++){
            int val = nums[i];

            if(val<0){
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(val, val*maxSoFar);
            minSoFar = Math.min(val, val*minSoFar);

            maxProd = Math.max(maxProd, maxSoFar);
        }
        return maxProd;
    }
}
