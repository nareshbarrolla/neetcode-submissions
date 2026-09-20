class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int max = 0;
        int currentMax = 0;
        int smallestValue = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(smallestValue == nums[i]){                
                continue;                
            }
            if(smallestValue == nums[i]-1){
                currentMax++;           
            }
            if(smallestValue != nums[i]-1){
                max = Math.max(currentMax, max);        
                currentMax = 1;                
            }
            smallestValue = nums[i];
        }
        return Math.max(currentMax, max);        
    }
}
