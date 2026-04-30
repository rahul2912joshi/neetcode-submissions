class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i=0; i<piles.length; i++){
            if(piles[i]>max) max=piles[i];
        }
        int left = 1;
        int right = max;

        while(left<right){
            int mid = (right-left)/2 + left;
            int time = findTime(piles,mid);
            if(time>h){
                left = mid+1;
            } else{
                right = mid;
            }
        }
        return left;
    }

    public int findTime(int[] piles, int speed){
        int time = 0;
        for(int i=0; i<piles.length; i++){
            time += piles[i]/speed;
            if(piles[i]%speed!=0) time++;
        }
        return time;
    }
}
