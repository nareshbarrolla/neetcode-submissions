class Solution {

    public int trap(int[] height) {
        int arrayLength = height.length;
        int result = 0;
        int[] prefixArray = new int[height.length];
        int[] suffixArray = new int[height.length];
        for(int i = 0; i < arrayLength; i++){
            if(i == 0){
                prefixArray[i] = height[i];
            }else{
                prefixArray[i] = Math.max(height[i], prefixArray[i-1]);
            }
        }
        for(int i = arrayLength-1; i >= 0; i--){
            if(i == arrayLength-1){
                suffixArray[i] = height[arrayLength-1];
            }else{
                suffixArray[i] = Math.max(height[i], suffixArray[i+1]);
            }
        }        
        for(int i = 1; i < arrayLength-1; i++){               
          int unitOfWaterCapacity = Math.min(prefixArray[i], suffixArray[i])-height[i];
            result = result+ Math.max(0,unitOfWaterCapacity);
        }      
        return result;                        
    }

    // private int getLeftMaxValue(int currentIndex, int[] height){
    //     int max = 0;     
    //     int temp = currentIndex-1;   
    //     while(temp >= 0){
    //        max = Math.max(max, height[temp]);
    //         temp--;                
    //     }
    //     return max;
    // }

    // private int getRightMaxValue(int currentIndex, int[] height){
    //     int max = 0;     
    //     int temp = currentIndex+1;   
    //     while(temp < height.length){
    //        max = Math.max(max, height[temp]);
    //         temp++;                
    //     }
    //     return max;
    // }
}