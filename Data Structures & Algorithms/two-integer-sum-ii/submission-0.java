class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> seen = new HashMap<>();
        for(int i=0; i<numbers.length;i++){
            int num = numbers[i];
            if(seen.containsKey(target-num)) return new int[]{seen.get(target-num)+1,i+1};
            seen.put(num,i);
        }
        return new int[]{-1,-1};
    }
}
