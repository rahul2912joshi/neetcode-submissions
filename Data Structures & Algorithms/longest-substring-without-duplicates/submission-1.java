class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int maxLen = 0;
        int start = 0, end=0;
        while(end<s.length()){
            char ch = s.charAt(end);
            if(seen.contains(ch)==false){
                seen.add(ch);
                end++;
                continue;
            }
            while(seen.contains(ch)){
                seen.remove(s.charAt(start));
                maxLen = Math.max(maxLen,end-start);
                start++;
            }
        }
        maxLen = Math.max(maxLen,end-start);
        return maxLen;
    }
}
