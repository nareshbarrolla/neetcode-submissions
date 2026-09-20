class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j){            
            if(!isAlphanumeric(s.charAt(i))){
                i++;
                continue;
            }
            if(!isAlphanumeric(s.charAt(j))){
                j--;
                continue;
            }            
            char leftChar = convertToLowerCase(s.charAt(i));
            char rightChar = convertToLowerCase(s.charAt(j));
            if(leftChar != rightChar){
                return false;
            }
            i++;
            j--;            
        }
        return true; 
    }

    public boolean isAlphanumeric(char c){
        return (c >= 'a' && c <= 'z') || 
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9'); 
    }

    public char convertToLowerCase(char c){
        if(c >= 'A' && c <= 'Z'){
            return (char)(c+('a'-'A'));                
        }
        return c;            
    }
}
