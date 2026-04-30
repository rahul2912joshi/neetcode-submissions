class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxLength = 0, maxCount = 0, start = 0;
        for(int i=0; i<s.length(); i++){
            int pos = s.charAt(i) - 'A';
            count[pos]++;
            maxCount = Math.max(maxCount,count[pos]);
            while((i-start+1) - maxCount > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, i-start+1);
        }
        return maxLength;
    }
}
