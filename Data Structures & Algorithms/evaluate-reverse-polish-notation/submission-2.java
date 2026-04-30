class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<tokens.length; i++){
            String val = tokens[i];
            if(val.equals("+")){
                int second = st.pop();
                int first = st.pop();
                st.push(first+second);
            } else if(val.equals("-")){
                int second = st.pop();
                int first = st.pop();
                st.push(first-second);
            } else if(val.equals("*")){
                int second = st.pop();
                int first = st.pop();
                st.push(first*second);
            } else if(val.equals("/")){
                int second = st.pop();
                int first = st.pop();
                st.push(first/second);
            } else{
                st.push(Integer.parseInt(val));
            }
        }
        return st.pop();
    }
}
