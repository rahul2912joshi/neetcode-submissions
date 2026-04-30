class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1, end=0;
        for(int i=0; i<piles.length; i++){
            if(piles[i]>end) end=piles[i];
        }

        while(start<end){
            int mid=start+(end-start)/2;
            int time =0;
            for(int i=0; i<piles.length; i++){
                time += Math.ceil((double)piles[i]/mid);
            }
            if(time>h){
                start = mid+1;
            } else{
                end = mid;
            }
        }
        return start;
    }
}
//25 10 23 4
// 1 25 -> 13 25 -> 20 25 -> 23 25 -> 25 25 -> 
