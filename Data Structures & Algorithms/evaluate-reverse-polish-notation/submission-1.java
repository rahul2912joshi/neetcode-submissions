class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(String exp : tokens){
            if(exp.equals("+")){
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());
                st.add(Integer.toString(num1+num2));
            } else if(exp.equals("-")){
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());
                st.add(Integer.toString(num1-num2));
            } else if(exp.equals("*")){
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());
                st.add(Integer.toString(num1*num2));
            } else if(exp.equals("/")){
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());
                st.add(Integer.toString(num1/num2));
            } else{
                st.add(exp);
            }
        }
        return Integer.parseInt(st.pop());
    }
}
// 1 2
