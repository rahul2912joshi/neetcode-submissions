class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            int len = str.length();
            sb.append(len);
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int n = 0;
            while(str.charAt(i)!='#'){
                n = (str.charAt(i)-'0') + n*10;
                i++;
            }
            String s = str.substring(i+1,i+1+n);
            result.add(s);
            i = i+n+1;
        }
        return result;       
    }
}
