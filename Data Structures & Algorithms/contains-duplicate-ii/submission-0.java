class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<=k && i<nums.length; i++){
            if(hs.contains(nums[i])) return true;
            else hs.add(nums[i]);
        }
        if(nums.length <=k) return false;
        int start = 0;
        for(int i=k+1; i<nums.length; i++){
            hs.remove(nums[start++]);
            if(hs.contains(nums[i])) return true;
            else hs.add(nums[i]);
        }
        return false;
    }
}