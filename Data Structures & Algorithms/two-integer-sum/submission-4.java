class Solution {
    public int[] twoSum(int[] nums, int target) {
                Map<Integer, Integer> seenValueMapping = new HashMap<>(nums.length * 2);
        int[] output = new int[2];
        for(int i = 0; i < nums.length; i ++){
            int requiredValueLookup = target - nums[i];
            Integer matchIndex = seenValueMapping.get(requiredValueLookup);
            if(matchIndex != null){
                output[0] =  matchIndex;
                output[1] =  i;
                break;
            }             
            seenValueMapping.put(nums[i], i);
        }
        return output;        
    }
}
