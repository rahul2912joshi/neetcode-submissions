class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,result,new ArrayList<Integer>(), target, 0);
        return result;
    }
    public void backtrack(int[] candidates, ArrayList<List<Integer>> result, ArrayList<Integer> curr, int target, int pos){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=pos; i<candidates.length; i++){
            if(i>pos && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;
            curr.add(candidates[i]);
            target = target-candidates[i];
            backtrack(candidates,result,curr,target,i+1);
            target = target+candidates[i];
            curr.remove(curr.size()-1);
        }
    }
}
