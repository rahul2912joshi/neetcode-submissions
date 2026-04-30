class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];
        result[result.length-1]=0;
        st.push(temperatures.length-1);
        for(int i=result.length-2; i>=0;i--){
            if(temperatures[i] < temperatures[st.peek()]){
                result[i]=st.peek()-i;
                st.push(i);
            } else {
                while(st.isEmpty()==false){
                    st.pop();
                    if(st.isEmpty()) break;
                    if(temperatures[i] < temperatures[st.peek()]){
                        result[i]=st.peek()-i;
                        st.push(i);
                        break;
                    }
                }
                if(st.isEmpty()){
                    result[i]=0;
                }
                st.push(i);
            }
        }
        return result;
    }
}
// 30 38 30 36 35 40 28
// st -> 5 1
// 0 0 1 2 1 4
