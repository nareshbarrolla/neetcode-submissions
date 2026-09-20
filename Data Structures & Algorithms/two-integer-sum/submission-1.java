class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenValueMapping = new HashMap();
        int[] output = new int[2];
        for(int i = 0; i < nums.length; i ++){
            int requiredValueLookup = target - nums[i];
            if(seenValueMapping.containsKey(requiredValueLookup)){
                output[0] =  seenValueMapping.get(requiredValueLookup);
                                output[1] =  i;
                                break;
            }             
            seenValueMapping.put(nums[i], i);
        }
        return output;        
    }
}
