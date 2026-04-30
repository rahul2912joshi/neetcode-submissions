class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        for(int i=0; i<senate.length(); i++){
            if(senate.charAt(i) == 'R') radiant.add(i);
            else dire.add(i);
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){
            int rindex = radiant.poll();
            int dindex = dire.poll();

            if(rindex < dindex){
                radiant.add(rindex + senate.length());
            } else{
                dire.add(dindex + senate.length());
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
/*
RRDDDDDD

*/