class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<asteroids.length; i++){
            int num = asteroids[i];
            if(num > 0) st.push(num);
            else pushnegative(st,num);
        }
        int[] result = new int[st.size()];
        int pos = result.length-1;
        while(!st.isEmpty()){
            result[pos] = st.pop();
            pos--;
        }
        return result;
    }
    public void pushnegative(Stack<Integer> st, int num){
        if(st.isEmpty()){
            st.push(num);
            return;
        }
        int val = st.peek();
        if(val < 0){
            st.push(num);
            return;
        }
        if(-num > val){
            st.pop();
            pushnegative(st, num);
        } else if(num*-1 < val){
            return;
        } else{
            st.pop();
            return;
        }
        return;
    }
}