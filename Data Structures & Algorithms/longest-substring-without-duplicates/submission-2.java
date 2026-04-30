class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int start = 0,maxLength=0;
        for(int end=0; end<s.length();end++){
            char c = s.charAt(end);
            if(seen.contains(c)){
                maxLength = Math.max(maxLength,end-start);
                while(seen.contains(c)){
                    seen.remove(s.charAt(start++));
                }
            }
            seen.add(c);
        }
        maxLength = Math.max(maxLength,s.length()-start);
        return maxLength;
    }
}

//zxyzxyz
