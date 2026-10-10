class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxValue(piles);        
        int result = right;
        while(left <=  right){ 
            int mid = left + (right-left)/2;       
            int hoursRequired = getHoursRequiredToFinishWithGivenRate(piles, mid);
            if(hoursRequired <= h){
                result = mid;
                right = mid-1;                
            }else{
                left = mid+1;
            }
        }        
        return result;                                                                                                
    }

    private int getHoursRequiredToFinishWithGivenRate(int[] piles, int currentPerHourRate){        
        int total = 0;
        for(int i = 0; i < piles.length; i++){
            total = total+getCeilingValue(piles[i], currentPerHourRate);
        }        
        return total;
    }

    private int getCeilingValue(int value, int deivder){
        int result = value/deivder;        
        if(value%deivder != 0){
           return result+1; 
        }        
        return result;            
    }

    private int getMaxValue(int[] piles){
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return max;
    }    
}
