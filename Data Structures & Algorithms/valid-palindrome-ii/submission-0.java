class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length()-1;
        return validate(s,start,end,new int[]{0});
    }
    public boolean validate(String s, int start, int end, int[] deleted){
        if(start>end) return true;

        if(s.charAt(start) == s.charAt(end)){
            return validate(s,start+1,end-1,deleted);
        } else if(deleted[0] == 0){
            deleted[0]  = 1;
            return validate(s,start+1,end,deleted) || validate(s,start,end-1,deleted);
        }
        return false;
    }
}