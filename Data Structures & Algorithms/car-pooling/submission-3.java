class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Arrays.sort(trips,(a,b) -> a[1]-b[1]);
        // Arrays.sort(trips,(a,b) -> Integer.compare(a[1],b[1]));

        // int[] ongoing = trips[0];
        // int passengers = ongoing[0];
        // if(passengers > capacity) return false;

        // for(int i=1; i<trips.length; i++){
        //     int[] curr = trips[i];
        //     if(curr[1] < ongoing[2]){
        //         passengers += curr[0];
        //         if(passengers > capacity) return false;
        //         ongoing[0] = passengers;
        //         ongoing[2] = Math.max(ongoing[2],curr[2]);
        //     } else{
        //         ongoing = curr;
        //         passengers = ongoing[0];
        //         if(passengers > capacity) return false;
        //     }
        // }
        // return true;
        int[] change = new int[1001];

        for(int[] trip : trips){
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];

            change[from] += num;
            change[to] -= num;
        }

        int curr =0;
        for(int i=0; i<change.length; i++){
            curr += change[i];
            if(curr>capacity) return false;
        }
        return true;
    }
}