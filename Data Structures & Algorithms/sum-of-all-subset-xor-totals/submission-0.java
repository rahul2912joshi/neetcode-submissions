class Solution {
    public int subsetXORSum(int[] nums) {
        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(0);
        for(int i=0; i<nums.length; i++){
            int len = subset.size();
            for(int j=0; j<len; j++){
                subset.add(subset.get(j) ^ nums[i]);
            }
        }
        int sum = 0;
        for(int num : subset){
            sum+=num;
        }
        return sum;
    }
}

// (), 3, 1, 31, 1, 31, 11, 311
// 0, 3, 1, 2, 
// sum = 3
// xor = 3 