class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] charOccuranceCount = new int[26];
        for(int i = 0; i < s.length(); i++){
            int charIndex = Character.toLowerCase(s.charAt(i))-'a';
            charOccuranceCount[charIndex]++;            
        }
        for(int i = 0; i < t.length(); i++){
            int charIndex = Character.toLowerCase(t.charAt(i))-'a';
            charOccuranceCount[charIndex]--;                    
        }    
        for(int i = 0; i < charOccuranceCount.length; i++){
            if(charOccuranceCount[i] != 0){
                return false;
            }
        }        
        return true;
    }
}
