class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        // if(s.length()==0) return 0;
        // if(s.length()==1) return 1;
        int maxLength = 0;
        int start = 0;
        // seen.add(s.charAt(0));
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            while(seen.contains(curr)){
                seen.remove(s.charAt(start++));
            }
            seen.add(curr);
            int currLength = i-start+1;
            maxLength = Math.max(currLength,maxLength);
        }
        return maxLength;
    }
}
