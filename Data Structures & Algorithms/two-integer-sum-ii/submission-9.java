class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int startIndex = 0;
        int endIndex = numbers.length;
        int arrayLength =  numbers.length;
        boolean result = false;
        if(arrayLength == 2){
            return new int[]{1, 2};
        }
        for(int i = 0; i < arrayLength; i++){
            startIndex = i;
            int requiredValue = target-numbers[i];
            int temp = i+1;
            int end = arrayLength - 1;            
            while(temp <= end){
                int binarySearchIndex = (temp+end)/2;
                if(numbers[binarySearchIndex]==requiredValue){
                   endIndex = binarySearchIndex;
                   result = true;
                   break; 
                }
                if(numbers[binarySearchIndex] < requiredValue){
                    temp = binarySearchIndex+1;
                }else if(numbers[binarySearchIndex] > requiredValue){
                    end = binarySearchIndex-1;
                }                    
            }
            if(result){
                break;  
            }                            
        }
        return new int[]{startIndex+1, endIndex+1};
    }
}
