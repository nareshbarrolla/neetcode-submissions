class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> trackingSet = new HashSet<>();
        int value = 0;
        for(int i = 0; i < nums.length; i++){
            if(!trackingSet.add(nums[i])){
                value = nums[i];
                break;
            }
        }
        return value;
    }
}
