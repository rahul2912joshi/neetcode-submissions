class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> values = new ArrayList<>();
        int pos = -1;
        for(String ch : operations){
            if(ch.equals("+")){
                values.add(values.get(pos) + values.get(pos-1));
                pos++;
            } else if(ch.equals("C")){
                values.remove(pos--);
            } else if(ch.equals("D")){
                values.add(values.get(pos)*2);
                pos++;
            } else{
                values.add(Integer.parseInt(ch));
                pos++;
            }
        }
        int sum = 0;
        for(int num : values){
            sum+=num;
        }
        return sum;
    }
}