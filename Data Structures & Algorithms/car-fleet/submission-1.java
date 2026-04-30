class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double time[][] = new double[position.length][2];

        for(int i=0; i<position.length; i++){
            time[i][1] = (double)(target-position[i])/speed[i];
            time[i][0] = position[i];
        }

        Arrays.sort(time, (a,b)-> Double.compare(b[0],a[0]));

        int fleets = 0;
        double prevtime = 0;
        for(int i=0; i<time.length; i++){
            double timenow = time[i][1];
            if(timenow > prevtime){
                fleets++;
                prevtime = timenow;
            }
        }
        return fleets;

    }
}

// 3 4.5 10 3
// 7 3, 4 3, 1 4.5, 0 10
