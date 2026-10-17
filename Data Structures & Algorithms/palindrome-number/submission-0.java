class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        final String input = String.valueOf(x);
        int start = 0;
        int end = input.length()-1;
        while(start <= end){
            if(input.charAt(start) == input.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}