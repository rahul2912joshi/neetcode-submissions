class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        map.put(0,1);

        for(int num : nums){
            prefixSum += num;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum-k);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}

// 2 -1 1 2

/*
count - 4;
map - 
0 1
2 2
1 1
4 1

prefixSum = 4;

*/