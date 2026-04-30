class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(result, 0, 0, sb, n);
        return result;
    }
    public void backtrack(ArrayList<String> result, int open, int close, StringBuilder sb, int max){
        if(sb.length()==max*2){
            result.add(sb.toString());
            return;
        }
        if(open<max){
            sb.append('(');
            backtrack(result,open+1,close,sb,max);
            sb.setLength(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            backtrack(result,open,close+1,sb,max);
            sb.setLength(sb.length()-1);
        }
    }
}
// (()
// ()(
// ((( 
