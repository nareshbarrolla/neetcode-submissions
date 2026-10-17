class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String commonPrefix = strs[0];
        for(int i = 1; i < strs.length; i++){            
            int index = 0;                           
            while(index < commonPrefix.length() && index < strs[i].length()){
                if(commonPrefix.charAt(index) == strs[i].charAt(index)){
                   index++; 
                }else{
                    break;
                }
            }            
            commonPrefix = commonPrefix.substring(0,index);
            if(commonPrefix.isEmpty()){
                return "";
            }
        }
        return commonPrefix;
    }
}