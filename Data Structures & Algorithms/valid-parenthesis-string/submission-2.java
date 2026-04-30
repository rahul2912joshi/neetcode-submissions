class Solution {
    public boolean checkValidString(String s) {
        int high = 0, low = 0;
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                low++;
                high++;
            } else if(ch==')'){
                low--;
                high--;
            } else{
                high++;
                low--;
            }
            if(low<0) low=0;
            if(high<0) return false;
        }
        return low==0;
        
    }
}
// ((**)
// open 2
// close 1
// * 2
