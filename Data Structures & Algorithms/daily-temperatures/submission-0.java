class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){            
            int warmerDayIndex = -1;
            for(int j = i+1; j < temperatures.length; j++){
                if(temperatures[j] > temperatures[i]){
                    warmerDayIndex = j-i;
                    break;
                }
            }
            if(warmerDayIndex > 0){
               result[i] = warmerDayIndex; 
            }else{
               result[i] = 0;     
            }
        }
        return result;       
    }
}
