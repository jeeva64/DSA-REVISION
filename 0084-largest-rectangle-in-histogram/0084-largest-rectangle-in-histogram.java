class Solution {
    //TC : O(3N) & SC : O(2N)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] pse = getSE(heights, n, 'P');
        int[] nse = getSE(heights, n, 'N');
        
        for(int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    private int[] getSE(int[] heights, int n, char flag) {
        Stack<Integer> stack = new Stack<>();
        int[] se = new int[n];

        //flag to reduce Time by O(2N) & Space by O(N)
        if(flag == 'P') {
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) 
                    stack.pop();

                se[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
        } else {
            for(int i = n-1; i >= 0; i--) {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) 
                    stack.pop();

                se[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
        }
        return se;
    }
}