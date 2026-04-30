class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] notes = new int[3];
        for(int i=0; i<bills.length; i++){
            int change = bills[i]-5;
            if(change==0){
                notes[0]++;
            } else if(change == 5){
                notes[1]++;
                if(notes[0] > 0){
                    notes[0]--;
                } else{
                    return false;
                }
            } else{
                notes[2]++;
                if(notes[1] > 0 && notes[0] > 0){
                    notes[1]--;
                    notes[0]--;
                } else if( notes[0] > 2){
                    notes[0] -= 3;
                } else{
                    return false;
                }
            }
        }
        return true;
    }
}