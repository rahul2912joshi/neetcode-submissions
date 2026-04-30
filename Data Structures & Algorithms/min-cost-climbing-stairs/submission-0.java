class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        if(cost.length == 0 || cost.length == 1) return 0;

        minCost[0]=0;
        minCost[1] = 0;

        for(int i=2; i<minCost.length; i++){
            minCost[i] = Math.min(minCost[i-2]+cost[i-2], minCost[i-1]+cost[i-1]);
        }
        return minCost[minCost.length-1];
    }
}
// start at -1, cost is 0.
// mincost[i] = min(mincost[i-2] + cost[i-2], mincost[i-1] + cost[i-1]);
//result = mincost[cost.length]