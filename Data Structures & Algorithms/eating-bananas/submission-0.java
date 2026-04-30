class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxNumber = 0;
        for(int i=0; i<piles.length; i++){
            maxNumber = Math.max(maxNumber, piles[i]);
        }

        int start=1, end=maxNumber, result = Integer.MAX_VALUE;

        while(start<=end){
            int mid = start + (end-start)/2, sum=0;

            for(int i=0; i<piles.length; i++){
                sum += (piles[i] + mid - 1) / mid;
            }
            if(sum<=h){
                end = mid-1;
                result = mid;
            } else{
                start = mid+1;
            }
            
        }
        return result;
    }
}
