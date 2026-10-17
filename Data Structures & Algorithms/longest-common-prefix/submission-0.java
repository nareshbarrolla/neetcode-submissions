class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String commonPrefix = strs[0];
        for(int i = 0; i < strs.length; i++){
            int commonPrefixLength = commonPrefix.length();
            int currentStringLength = strs[i].length();
            int lengthToProcess = Math.min(commonPrefixLength, currentStringLength);
            String temp = "";                
            for(int j = 0; j < lengthToProcess; j++){
                if(commonPrefix.charAt(j) == strs[i].charAt(j)){
                    temp = temp+commonPrefix.charAt(j);                    
                }else{
                    break;
                }
            }
            commonPrefix = temp;
        }
        return commonPrefix;
    }
}