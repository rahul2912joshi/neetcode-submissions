class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> present = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            present.add(nums[i]);
        }

        int max = 0;

        for(int num : present){
            if(present.contains(num-1)) continue;
            int length=1;
            int curr = num;
            while(present.contains(curr+1)){
                length++;
                curr++;
            }
            max = Math.max(max,length);
        }
        return max;

    }
}
