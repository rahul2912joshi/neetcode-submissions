class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start<end){
            Character st = Character.toLowerCase(s.charAt(start));
            Character ed = Character.toLowerCase(s.charAt(end));
            System.out.println("st = " + st);
            System.out.println("ed = " + ed);
            if(st < 48 || (st > 57 && st < 97) || st > 122){
                start++;
            }
            else if(ed < 48 || (ed > 57 && ed < 97) || ed > 122){
                end--;
            } else{
                if(st != ed){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
