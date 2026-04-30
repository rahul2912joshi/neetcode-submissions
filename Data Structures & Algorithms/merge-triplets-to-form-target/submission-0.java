class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int maxa =0, maxb=0, maxc=0;
        int x=target[0], y=target[1], z=target[2];
        for(int i=0; i<triplets.length; i++){
            int[] current = triplets[i];
            int a=current[0], b=current[1], c=current[2];
            if(a<=x && b<=y && c<=z){
                maxa = Math.max(maxa,a);
                maxb = Math.max(maxb,b);
                maxc = Math.max(maxc,c);
            }
        }
        if(maxa==x && maxb==y && maxc==z) return true;
        return false;
    }
}
