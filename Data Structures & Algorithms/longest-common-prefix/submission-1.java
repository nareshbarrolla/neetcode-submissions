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
            int index = 0;                           
            while(index < commonPrefix.length() && index < strs[i].length()){
                if(commonPrefix.charAt(index) == strs[i].charAt(index)){
                   index++; 
                }else{
                    break;
                }
            }            
            commonPrefix = commonPrefix.substring(0,index);
        }
        return commonPrefix;
    }
}