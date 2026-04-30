class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n==0) return 0;

        double cars[][] = new double[n][2];
        for(int i=0; i<n ; i++){
            int pos = position[i];
            double time = (double)(target-position[i])/speed[i];
            cars[i][0] = pos;
            cars[i][1] = time;
        }
        Arrays.sort(cars,(a,b) -> Double.compare(b[0],a[0]));

        int fleet = 0;
        double prevtime = 0;
        for(int i=0; i<n; i++){
            double time = cars[i][1];
            if(time > prevtime){
                fleet++;
                prevtime = time;
            }
        }
        return fleet;
    }
}
