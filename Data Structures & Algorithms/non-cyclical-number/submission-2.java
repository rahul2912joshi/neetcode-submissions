class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        int sum = n;
        while(sum != 1){
            if(seen.contains(sum)) return false;
            seen.add(sum);
            sum = sumsq(sum);
        }
        return true;
    }
    public int sumsq(int n){
        int sum = 0;
        while(n>0){
            int k = n%10;
            sum+=k*k;
            n=n/10;
        }
        return sum;
    }
}
