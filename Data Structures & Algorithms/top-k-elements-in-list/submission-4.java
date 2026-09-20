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

        int[][] valueToOccuranceCountPair = new int[valueToOccuranceCountTracker.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : valueToOccuranceCountTracker.entrySet()){
            valueToOccuranceCountPair[index][0] = entry.getKey();
            valueToOccuranceCountPair[index][1] = entry.getValue();
            // System.out.println("1 => " + valueToOccuranceCountPair[index][0] + " value " + valueToOccuranceCountPair[index][1]);
            index++;
        }

        for(int i = 0; i < valueToOccuranceCountPair.length; i++){
            int minValueIndex = i;
            for(int j = i+1; j < valueToOccuranceCountPair.length; j++){
                if(valueToOccuranceCountPair[minValueIndex][1] > valueToOccuranceCountPair[j][1]){
                    minValueIndex = j;
                }                    
            }
            int[] temp = valueToOccuranceCountPair[i];
            valueToOccuranceCountPair[i] = valueToOccuranceCountPair[minValueIndex];
            valueToOccuranceCountPair[minValueIndex] = temp;
            // System.out.println(valueToOccuranceCountPair[i][0] + " value " + valueToOccuranceCountPair[i][1]);
        }
        int finalIndex = 0;
        for(int i = valueToOccuranceCountPair.length-1; i >= 0; i--){
            if(k > 0){
                results[finalIndex++] = valueToOccuranceCountPair[i][0];
                k--;                     
            }else{
                break;
            }                
        } 
        return results;           
    }
}
