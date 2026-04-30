class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int k = nums[i];
            int rem = 0-k;
            int start = i+1, end=nums.length-1;
            while(start<end){
                if(nums[start]+nums[end]==rem){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(k);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);
                    while(start<end && nums[start]==nums[start+1]) start++;
                    while(start<end && nums[end]==nums[end-1]) end--;
                    start++;
                    end--;
                } else if(nums[start]+nums[end]>rem){
                    end--;
                } else{
                    start++;
                }
            }
        }
        return result;
    }
}
// -4 -1 -1 0 1 2
