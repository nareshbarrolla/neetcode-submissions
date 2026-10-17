class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countToValue = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(countToValue.containsKey(nums[i])){
                int temp = countToValue.get(nums[i]);
                countToValue.put(nums[i], temp+1);
            }else{
                countToValue.put(nums[i], 1);
            }
        }
        double majorityElementCount = nums.length/2;
        int output = 0;
        for(Map.Entry<Integer, Integer> entry : countToValue.entrySet()){
            if(entry.getValue() > majorityElementCount){
                output =  entry.getKey();
                break;
            }
        }
        return output;
    }
}