class Solution {

    static final String delimiter = "#";

    public String encode(List<String> strs) {
        String encodedString = "";
        if(strs.isEmpty()){
            return "";
        }                
        for(String strValue : strs){
            int strValueLength =  strValue.length();            
            String updatedString  = strValueLength+delimiter+strValue;
            encodedString = encodedString+updatedString;            
        }
        return encodedString;         
    }

    public List<String> decode(String str) {
        String stringLength = "";
        int currentStringLength=0; 
        String trackingString = "";
        List<String> results = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);            
            if(currentStringLength > 0){
                trackingString = trackingString+currentChar;
                currentStringLength--;
                if(currentStringLength == 0){
                   results.add(trackingString);
                   trackingString="";               
                }                    
            } else if(currentChar == '#'){
               currentStringLength = Integer.parseInt(stringLength);                
               if(currentStringLength == 0){
                 results.add("");
               }
               stringLength = "";
            } else{
               stringLength = stringLength+currentChar;
            }            
        }
        return results;        
    }
}
