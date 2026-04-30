class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> lastIndex = new HashMap<>();
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(!lastIndex.containsKey(ch)){
                lastIndex.put(ch,i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int count = 1;
        int maxLast=lastIndex.get(s.charAt(0));
        for(int i=1; i<s.length();i++){
            if(i>maxLast) {
                result.add(count);
                count=1;
                maxLast = lastIndex.get(s.charAt(i));
            } else{
                maxLast = Math.max(maxLast, lastIndex.get(s.charAt(i)));
                count++;
            }
        }
        result.add(count);
        return result;
    }
}
