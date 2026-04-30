class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] str = s.toCharArray();
            Arrays.sort(str);
            String key = new String(str);

            if(!map.containsKey(key)){
                ArrayList<String> arrList = new ArrayList<>();
                arrList.add(s);
                map.put(key,arrList);
            } else{
                ArrayList<String> arrList = new ArrayList<>(map.get(key));
                arrList.add(s);
                map.put(key,arrList);
            }
        }

        return new ArrayList<>(map.values());
    }
}
