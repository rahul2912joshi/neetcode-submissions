class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int len1 = s1.length();
        int len2 = s2.length();

        int[] freq = new int[26];
        for(char ch : s1.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i=0; i<len1 ; i++){
            freq[s2.charAt(i)-'a']--;
        }
        int start=0, end=len1;
        int[] check = new int[26];
        while(end<len2){
            if(Arrays.equals(freq,check)) return true;
            freq[s2.charAt(start)-'a']++;
            freq[s2.charAt(end)-'a']--;
            start++;
            end++;
        }
        if(Arrays.equals(freq,check)) return true;
        return false;

    }
}
