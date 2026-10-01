class Solution {
 
    final static Map<Character, Character> openParenthesesMappingConfig = new HashMap<>();    
    static{
        openParenthesesMappingConfig.put('(',')');
        openParenthesesMappingConfig.put('{','}');
        openParenthesesMappingConfig.put('[',']');
    }


    public boolean isValid(String s) {

        if(s == null || s.length() == 1){
            return false;
        }
        
        Deque<Character> inputStack  = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            final char value = s.charAt(i);
            if(openParenthesesMappingConfig.containsKey(value)){
                inputStack.push(openParenthesesMappingConfig.get(value));
            }else{
                if(!inputStack.isEmpty()){
                    if(inputStack.pop() != value){
                        return false;
                    }
                }else{
                    return false;
                }
            }                    
        }
        if(inputStack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
