class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();
        for(int pos=0;pos<strs[0].length();pos++){
            char c = strs[0].charAt(pos);
            for(int i=1; i<strs.length; i++){
                if(strs[i].length()<=pos || strs[i].charAt(pos)!=c) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}