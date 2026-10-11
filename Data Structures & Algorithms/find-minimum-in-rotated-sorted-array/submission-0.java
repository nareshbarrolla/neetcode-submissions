class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;    
        while(start <= end ){
            int 
            mid = start+(end-start)/2;
            if(nums[mid] > nums[end]){
                start = mid+1;
            }else{
                end = mid-1;
            }
            min = Math.min(min, nums[mid]);            
        }
        return min;                
    }
}
