class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(a[0],b[0]));
        Deque<Double> trackingStack = new ArrayDeque<>();
        for(int i = position.length-1; i >= 0; i--){
             double timeToReachDestination = (double) (target - cars[i][0]) / cars[i][1];
             if(trackingStack.isEmpty() || timeToReachDestination > trackingStack.peek()){
                trackingStack.push(timeToReachDestination);
             }
        }        
        return trackingStack.size();        
    }

}
