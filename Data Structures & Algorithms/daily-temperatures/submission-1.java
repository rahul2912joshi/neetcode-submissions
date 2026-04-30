class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i=result.length-1; i>=0; i--){
            if(st.isEmpty()){
                result[i] = 0;
                st.push(i);
            } else{
                while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    result[i] = 0;
                    st.push(i);
                } else{
                    result[i] = st.peek()-i;
                    st.push(i);
                }
            }
        }
        return result;
    }
}
// 0  1  2  3  4  5  6
// 30 38 30 36 35 40 28
// 1 4 1 2 1 0 0
// 1 5 3 5 5 0 0
// 1 4 1 2 1 0 0

// 5  1 0

