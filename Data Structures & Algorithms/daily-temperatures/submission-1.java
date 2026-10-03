class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Deque<Integer> monotonicStack = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++){            
            while(!monotonicStack.isEmpty() && temperatures[i] > temperatures[monotonicStack.peek()]){
                int daysAfterWarmDayFound = i-monotonicStack.peek();
                result[monotonicStack.peek()] = daysAfterWarmDayFound;
                monotonicStack.pop();
            }
            monotonicStack.push(i);
        }
        while(!monotonicStack.isEmpty()){
            result[monotonicStack.pop()] = 0;
        }
        return result;       
    }
}
