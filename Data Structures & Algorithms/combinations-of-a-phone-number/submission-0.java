class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<StringBuilder> res = new ArrayList<>();
        res.add(new StringBuilder());
        for(int i=0; i<digits.length(); i++){
            int k = digits.charAt(i) - '0';
            int len = res.size();
            for(char ch : map[k].toCharArray()){
                for(int j=0; j<len ;j++){
                    StringBuilder s = new StringBuilder(res.get(j));
                    s.append(ch);
                    res.add(s);
                }
            }
            for(int j=len-1; j>=0 ;j--){
                res.remove(j);
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<res.size(); i++){
            result.add(res.get(i).toString());
        }
        return result;
    }
}
