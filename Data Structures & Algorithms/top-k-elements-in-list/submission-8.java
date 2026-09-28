class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> valueToCountMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(valueToCountMap.containsKey(nums[i])){                
                int temp = valueToCountMap.get(nums[i]);                                
                valueToCountMap.put(nums[i], temp+1);                
            }else{            
                valueToCountMap.put(nums[i], 1);
            }
        }        
        Map<Integer, Set<Integer>> occuranceToValueMap = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : valueToCountMap.entrySet()){
            if(occuranceToValueMap.containsKey(entry.getValue())){
                Set<Integer> currentList = occuranceToValueMap.get(entry.getValue());
                currentList.add(entry.getKey());                                    
            }else{
                Set<Integer> relatedNumber = new HashSet<>();
                relatedNumber.add(entry.getKey());
                occuranceToValueMap.put(entry.getValue(), relatedNumber);
            }            
        }

        int temp = nums.length;
        int[] result = new int[k];
        int count = 0;
        while(temp > 0){
            if(occuranceToValueMap.containsKey(temp)){
                Set<Integer> values = occuranceToValueMap.get(temp);
                for(Integer num : values){
                    result[count++] = num;
                }
                if(count == k){   // FIX 5
                    break;
                }
            }
            temp--;
        }                                   
        return result;
    }
}
