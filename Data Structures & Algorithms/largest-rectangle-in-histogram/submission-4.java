class Solution {
    public int largestRectangleArea(int[] heights) {        

        int[] previousSmallarElement = getpreviousSmallarElements(heights);
        int[] nextSmallarElement = getNextSmallarElements(heights);
    
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){            
            int area = heights[i] * (nextSmallarElement[i]-previousSmallarElement[i]-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int[] getpreviousSmallarElements(int[] heights){
        int[] previousSmallarElement = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            previousSmallarElement[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return previousSmallarElement;
    }

    private int[] getNextSmallarElements(int[] heights){
        int[] nextSmallarElement = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = heights.length-1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            nextSmallarElement[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        return nextSmallarElement;
    }    
}
