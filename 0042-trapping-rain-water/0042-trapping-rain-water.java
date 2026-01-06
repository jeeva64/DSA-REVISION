class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1, maxLeft = 0, maxRight = 0, result = 0;

        while(left <= right) {
            if(height[left] < height[right]) {
                //Finds maximum left so far
                if(height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                //Adds trapped rain water squares from left pointer
                    result += maxLeft - height[left];
                }
                left++;
            } else {
                //Finds maximum right so far
                if(height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                //Adds trapped rain water squares from right pointer
                    result += maxRight - height[right];
                }
                right--;
            }
        }
        return result;
    }
}