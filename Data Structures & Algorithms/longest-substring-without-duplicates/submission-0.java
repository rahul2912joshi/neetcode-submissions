class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int start = 0, max = Integer.MIN_VALUE;
        for(int end=0; end<=s.length(); ){
            if(end==s.length()){
                max = Math.max(max, end-start);
                end++;
            } else if(index[s.charAt(end)]==0){
                index[s.charAt(end)]=1;
                end++;
            } else{
                max = Math.max(max, end-start);
                index[s.charAt(start)] = 0;
                start++;
            }
        }
        return max;
    }
}
