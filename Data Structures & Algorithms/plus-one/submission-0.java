class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int length = digits.length;
        int val = digits[length-1] + 1;
        if(val < 10){
            digits[length-1] = val;
            return digits;
        }
        for(int i = length-1; i>=0; i--){
            val = digits[i] + carry;
            if(val < 10){
                digits[i] = val;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[length+1];
        ans[0] = 1;
        return ans;

    }
}
