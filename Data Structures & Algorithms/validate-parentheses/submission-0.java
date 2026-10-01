class Solution {
 
    final static Map<Character, Character> openParenthesesMappingConfig = new HashMap<>();    
    final static Map<Character, Character> closedParenthesesMappingConfig = new HashMap<>();    

    static{
        openParenthesesMappingConfig.put('(',')');
        openParenthesesMappingConfig.put('{','}');
        openParenthesesMappingConfig.put('[',']');

        closedParenthesesMappingConfig.put(')','(');
        closedParenthesesMappingConfig.put('}','{');
        closedParenthesesMappingConfig.put(']','[');
    }


    public boolean isValid(String s) {

        if(s == null || s.length() == 1){
            return false;
        }
        
        Deque<Character> inputStack  = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            final char value = s.charAt(i);
            if(openParenthesesMappingConfig.containsKey(value)){
                inputStack.push(value);
            }
            if(closedParenthesesMappingConfig.containsKey(value)){
                if(!inputStack.isEmpty()){
                    if(inputStack.pop() != closedParenthesesMappingConfig.get(value)){
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
