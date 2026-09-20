class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            char leftChar = convertToLowverCase(s.charAt(i));
            char rightChar = convertToLowverCase(s.charAt(j));
            if(isAlphanumeric(leftChar) && isAlphanumeric(rightChar)){
                if(leftChar == rightChar){
                    i++;
                    j--;
                }else{
                    return false;
                }                
            }
            if(isAlphanumeric(leftChar) && !isAlphanumeric(rightChar)){
                j--;
            }
            if(!isAlphanumeric(leftChar) && isAlphanumeric(rightChar)){
                i++;
            }
            if(!isAlphanumeric(leftChar) && !isAlphanumeric(rightChar)){
                i++;
                j--;
            }
        }
        return true; 
    }

    public boolean isAlphanumeric(char c){
        return (c >= 'a' && c <= 'z') || 
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9'); 
    }

    public char convertToLowverCase(char c){
        if(c >= 'A' && c <= 'Z'){
            return (char)(c+('a'-'A'));                
        }
        return c;            
    }
}
