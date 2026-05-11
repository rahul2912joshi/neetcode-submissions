class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int[] values = new int[3];
        int[] result = new int[3];

        for(int i=0; i<s.length(); i++){
            findPalindrome(s, i,i, values);
            if(values[0] > result[0]){
                result[0] = values[0];
                result[1] = values[1];
                result[2] = values[2];
            }
            findPalindrome(s,i,i+1,values);
            if(values[0] > result[0]){
                result[0] = values[0];
                result[1] = values[1];
                result[2] = values[2];
            }
        }
        return s.substring(result[1],result[2]+1);
    }
}

public void findPalindrome(String s, int mid1, int mid2, int[] values){
    while(mid1>=0 && mid2<s.length() && s.charAt(mid1)==s.charAt(mid2)){
        mid1--;
        mid2++;
    }
    values[1] = mid1+1;
    values[2] = mid2-1;
    values[0] = values[2]-values[1]+1;
}

// ababd len = 5
// mid1 = 0
// mid2 = 2
// values = 0,0,0
