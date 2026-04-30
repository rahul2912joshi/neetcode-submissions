class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if(n==0) return 1;
        if(n<0){
            x = 1/x;
            n = -n;
        }
        while(n>1){
            if(n%2==1){
                ans *= x;
                n = n-1;
            }
            else{
                x *=x;
                n = n/2;
            }
        }
        ans *=x;
        return ans;
    }
}
