class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer,Integer> freq = new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            freq.put(hand[i],freq.getOrDefault(hand[i],0)+1);
        }

        while(!freq.isEmpty()){
            int start = freq.firstKey();
            for(int i=0; i<groupSize; i++){
                int val = start+i;
                if(!freq.containsKey(val)){
                    return false;
                }
                freq.put(val,freq.get(val)-1);
                if(freq.get(val)==0){
                    freq.remove(val);
                }
            }
        }
        return true;
    }
}
// 1-1 2-2 3-2 4-2 5-1
// 1 2 3 4
// 2 3 4 5