class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();
                
        for(int i = 0; i < tokens.length; i ++){
            if(tokens[i].equals("+")){
                int value_1 = stack.pop();
                int value_2 = stack.pop();
                stack.push((value_2+value_1));
            } else if(tokens[i].equals("-")){
                int value_1 = stack.pop();
                int value_2 = stack.pop();
                stack.push((value_2-value_1));
            } else if(tokens[i].equals("*")){
                int value_1 = stack.pop();
                int value_2 = stack.pop();
                stack.push((value_2*value_1));
            } else if(tokens[i].equals("/")){
                int value_1 = stack.pop();
                int value_2 = stack.pop();
                stack.push((value_2/value_1));             
            } else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }


}
