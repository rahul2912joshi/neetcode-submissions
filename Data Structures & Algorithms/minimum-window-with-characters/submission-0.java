class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        HashMap<Character,Integer> chars = new HashMap<>();
        for(int i=0; i<t.length();i++){
            chars.put(t.charAt(i),chars.getOrDefault(t.charAt(i),0)+1);
        }

        HashMap<Character,Integer> sub = new HashMap<>();
        int charmatch=0, total = chars.size(), start=0, minLength=Integer.MAX_VALUE;
        int startIndex = -1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            sub.put(ch,sub.getOrDefault(ch,0)+1);

            if(chars.containsKey(ch) && chars.get(ch) == sub.get(ch)){
                charmatch++;
            }

            while(charmatch == total){
                if(minLength > i-start+1){
                    minLength = i-start+1;
                    startIndex = start;
                }
                char cha = s.charAt(start);
                sub.put(cha,sub.get(cha)-1);
                if(chars.containsKey(cha) && sub.get(cha) < chars.get(cha)){
                    charmatch--;
                }
                start++;
            }
        }
        return minLength==Integer.MAX_VALUE ? "" : s.substring(startIndex,startIndex+minLength);
    }
}
// xyz - set
// ouzodyx -> all set present;
// length - 7
// 5
//odyxaz
// yxaz
//4
//xazv
