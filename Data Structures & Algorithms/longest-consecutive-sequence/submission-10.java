class Solution {
    public int longestConsecutive(int[] nums) {        
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        HashSet<Integer> numbers = new HashSet<>(nums.length);
        for(int i = 0; i < nums.length; i++){
           numbers.add(nums[i]);                 
        }
        
        int max = 1; 
        for(int number : numbers){            
            if(numbers.contains(number-1)){
                continue;                    
            }else{
               int currentMax = 1; 
               int temp = number+1;
               while(numbers.contains(temp)){
                    currentMax++;
                    temp = temp+1;                     
               }
               max = Math.max(max,currentMax);             
            }                            
        }
        return max;        
    }
}
