class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch -'a']++;
        }
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<26; i++){
            if(freq[i]>0){
                maxheap.add(new int[]{i,freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(maxheap.size()>=2){
            int[] first = maxheap.poll();
            int[] second = maxheap.poll();

            sb.append((char)(first[0] + 'a'));
            sb.append((char)(second[0] + 'a'));

            if(first[1]>1) maxheap.add(new int[]{first[0],first[1]-1});
            if(second[1]>1) maxheap.add(new int[]{second[0],second[1]-1});
        }

        if(!maxheap.isEmpty()){
            int[] val = maxheap.poll();
            if(val[1] > 1) return "";
            sb.append((char)(val[0]+ 'a'));
        }
        return sb.toString();
    }
}