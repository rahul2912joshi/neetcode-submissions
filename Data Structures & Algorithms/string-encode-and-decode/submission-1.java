class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            int len = str.length();
            sb.append(len + "#" + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            i = j+1;
            String value = str.substring(i,i+len);
            result.add(value);
            i = i+len;
        }
        return result;
    }
}
