class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrack(nums,result,new ArrayList<>(),target,0);
        return result;
    }
    public void backtrack(int[] nums, ArrayList<List<Integer>> result, ArrayList<Integer> curr, int target, int pos){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) return;

        for(int i=pos; i<nums.length; i++){
            curr.add(nums[i]);
            backtrack(nums,result,curr,target-nums[i],i);
            curr.remove(curr.size()-1);
        }
    }
}
