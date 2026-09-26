class Solution {

    public int trap(int[] height) {

        int arrayLength = height.length;

        int result = 0;

        int left = 0;
        int right = arrayLength-1;

        int leftMax = height[0];
        int rightMax = height[arrayLength-1];

        while(left <= right){
            if(leftMax <= rightMax){                 
                result = result +  Math.max(0, leftMax-height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }else{
                result = result +  Math.max(0, rightMax-height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
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