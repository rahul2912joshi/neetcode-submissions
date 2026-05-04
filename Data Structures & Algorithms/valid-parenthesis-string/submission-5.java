class Solution {
    public boolean checkValidString(String s) {
        int openMin = 0, openMax = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                openMin++;
                openMax++;
            } else if(ch==')'){
                openMin--;
                openMax--;
                if(openMax<0) return false;
            } else{
                openMin--;
                openMax++;
                if(openMin<0) openMin=0;
            }
        }
        return openMin<=0;
    }
}

// ((((()))***
// open_min -2
// open_max 18