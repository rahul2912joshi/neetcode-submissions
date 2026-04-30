class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String str = new String(s);
            if(map.containsKey(str)){
                ArrayList<String> newlist = map.get(str);
                newlist.add(strs[i]);
                map.put(str,newlist);
            } else{
                ArrayList<String> newEmpty = new ArrayList<>();
                newEmpty.add(strs[i]);
                map.put(str,newEmpty);
            }
        }
        ArrayList<List<String>> result = new ArrayList<>();
        for(ArrayList<String> list : map.values()){
            result.add(list);
        }
        return result;
    }
}
