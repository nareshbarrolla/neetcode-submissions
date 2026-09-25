class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        if(nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> output = new ArrayList<>();
        HashSet<String> setOutput = new HashSet<>();             
        int target = 0;
        for(int i = 0; i < nums.length-2; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
               int sum = nums[i]+nums[left]+nums[right]; 
                if(sum == target){                    
                    if(setOutput.add(nums[i]+","+nums[left]+","+nums[right])){
                        output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    left++;
                    right--;
                } else if(sum < target){
                    left++;
                }else{
                    right--;
                }                      
            }
        }        
        return output;
    }
}
