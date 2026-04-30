class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        int length = 0;
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        length++;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                String curr = q.poll();
                if(endWord.equals(curr)) return length;
                char[] arr = curr.toCharArray();
                for(int pos=0; pos<arr.length; pos++){
                    char orig = arr[pos];
                    for( char c='a'; c<='z';c++){
                        if(c!=orig){
                            arr[pos]=c;
                            String str = new String(arr);
                            if(wordSet.contains(str)){
                                q.add(str);
                                wordSet.remove(str);
                            }
                        }
                    }
                    arr[pos]=orig;
                }
            }
            length++;
        }
        return 0;

    }
}
// cat -> aat, bat, dat, eat,......,yat,zat;
// -> cbt, cct, cdt ,,,, cyt, czt;
// -> caa, cab, cac,,,, cay, caz;

// bat -> aat, 
