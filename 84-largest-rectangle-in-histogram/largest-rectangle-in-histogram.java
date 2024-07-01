class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();
        
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                leftSmall[i] = -1;  // Assume the nearest smaller to the left is out of bounds
            } 
            else {
                leftSmall[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                rightSmall[i] = n;  // Assume the nearest smaller to the right is out of bounds
            } 
            else {
                rightSmall[i] = stack.peek();
            }

            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmall[i] - leftSmall[i] - 1));
        }
        return maxArea;
    }
}