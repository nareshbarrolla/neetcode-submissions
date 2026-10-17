class Solution {
    public int maxProfit(int[] prices) {       
       if(prices.length == 1){
        return 0;
       }
       int max = 0;
       int min = prices[0];
       for(int i = 1; i < prices.length; i++){
         if(prices[i] > min){
            int temp = prices[i] - min;
            max = Math.max(temp, max);            
         }
         min = Math.min(prices[i], min);
       }
       return max;       
    }
}
