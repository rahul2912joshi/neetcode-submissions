class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> triplets = new ArrayList<>();

        for(int i=0; i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int start = i+1, end=nums.length-1, sum = 0-nums[i];
            while(start<end){
                int tempSum = nums[start] + nums[end];
                if(tempSum == sum){
                    triplets.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    // ArrayList<Integer> trip = new ArrayList<>();
                    // trip.add(nums[i]);
                    // trip.add(nums[start]);
                    // trip.add(nums[end]);
                    // triplets.add(trip);
                    while(start<end && nums[start] == nums[start+1]) start++;
                    while(start<end && nums[end] == nums[end-1]) end--;
                    start++;
                    end--;
                } else if(tempSum > sum){
                    end--;
                } else{
                    start++;
                }
            }
        }
        return triplets;
    }
}
