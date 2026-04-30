class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        int pr=1;
        prod[0] = pr;
        for(int i=1;i<nums.length;i++){
            pr*=nums[i-1];
            prod[i]=pr;
        }
        //pr=nums[nums.length-1];
        pr=1;
        for(int i=nums.length-2;i>=0;i--){
            pr*=nums[i+1];
            prod[i] *=pr;
        }
        return prod;
    }
}
// 1 2 4 6
// 1 1 2 8
// 
