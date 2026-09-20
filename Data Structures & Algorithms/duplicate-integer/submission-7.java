class Solution {

    public boolean hasDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            int minIdx = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[minIdx] > nums[j]){
                    minIdx = j;                    
                }
            }
              int temp = nums[i];
              nums[i] = nums[minIdx];
              nums[minIdx] = temp;
        }
        for(int i = 0; i < nums.length-1; i++){            
            if(nums[i] == nums[i+1]){
                return true;
            }
        }      
        return false;
    }

}