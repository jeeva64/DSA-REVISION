class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, maxArea = 0;

        while(left < right) {
            //Finds minimum block of building for water 
            int curHeight = Math.min(height[left], height[right]);
            int width = right - left;
            //Current water storage area
            int area = curHeight * width;
            //Maximum area for result
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}