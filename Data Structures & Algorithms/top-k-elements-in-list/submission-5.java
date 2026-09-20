class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] results = new int[k];        
        Map<Integer, Integer> valueToOccuranceCountTracker = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer occuranceCount = valueToOccuranceCountTracker.get(nums[i]);
            if(occuranceCount == null){
                valueToOccuranceCountTracker.put(nums[i], 1);
            }else{                
                occuranceCount = occuranceCount+1;
                valueToOccuranceCountTracker.put(nums[i], occuranceCount);
            }
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : valueToOccuranceCountTracker.entrySet()){
            int count = entry.getValue();
            if(buckets[count] == null){
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(entry.getKey());
        }

        int resultIndex = 0;
        for(int i = buckets.length-1; i > 0 && resultIndex < k; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    results[resultIndex++] = num;
                    if(resultIndex == k){
                        break;
                    }    
                }
            }
        }

        return results;           
    }
}
