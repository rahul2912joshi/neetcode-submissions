class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,0,target,result, new ArrayList<>());
        return result;
    }
    public void backtrack(int sum, int[] nums, int pos, int target, List<List<Integer>> result, List<Integer> current){
        if(sum > target) return;
        if(sum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=pos; i<nums.length; i++){
            sum+=nums[i];
            current.add(nums[i]);
            backtrack(sum,nums,i,target,result,current);
            current.remove(current.size()-1);
            sum-=nums[i];
        }
    }
}
