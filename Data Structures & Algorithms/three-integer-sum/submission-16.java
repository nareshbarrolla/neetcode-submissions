class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<>();

       for(int i = 0; i < nums.length-2; i++){
         if(i > 0 && nums[i] == nums[i-1]){
            continue;
         }
         int left = i+1;
         int right = nums.length-1;
         int target = 0;         
         while(left < right){
            int value = nums[i]+nums[left]+nums[right];   
            if(value == target){
                List<Integer> matchedIndexSet = new ArrayList<>();
                matchedIndexSet.add(nums[i]);
                matchedIndexSet.add(nums[left]);
                matchedIndexSet.add(nums[right]);
                result.add(matchedIndexSet);
                left++;
                right--;
                while(left < right && nums[left] == nums[left-1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right+1]){
                   right--; 
                }
            } else if (value > target){
                right--;
            } else{
                left++;
            }               
         }
       }
       return result;
    }
}
