class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int carry = (a&b) << 1;
            a = a^b;
            b = carry;
        }
        return a;
    }
}
// 100
// 111

// a 0011
// b 1000

// a 1011
// b 0

