class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=digits.length-1;i>=0;i--){
            int sum = digits[i]+carry;
            if(sum<10){
                result.add(sum);
                carry=0;
            } else{
                result.add(0);
                carry=1;
            }
        }
        if(carry==1) result.add(1);
        Collections.reverse(result);
        int[] res = new int[result.size()];
        for(int i=0; i<res.length; i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
