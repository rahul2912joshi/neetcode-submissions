class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int  maxCount = 0;
        int maxLength = 0;
        int start = 0, end=0;
        while(end<s.length()){
            freq[s.charAt(end) - 'A']++;
            maxCount = Math.max(freq[s.charAt(end)-'A'],maxCount);
            while((end-start+1)-maxCount > k){
                freq[s.charAt(start)-'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end-start);
            end++;
        }
        maxLength = Math.max(maxLength, end-start);
        return maxLength;

    }
}
// end-start+1 - maxCount > 2 ---- not okay maxlength = end-start , maxLength
// ABCAABCCCDD 3
