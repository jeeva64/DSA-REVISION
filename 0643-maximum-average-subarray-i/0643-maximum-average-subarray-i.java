class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        
        //First k Window Sum
        for(int i = 0; i < k; i++) 
            windowSum += nums[i];

        //Slide Window & get maximum sum window's value
        int maxSum = windowSum;
        for(int i = k; i < nums.length; i++) {
            windowSum -= nums[i-k];
            windowSum += nums[i];
            maxSum = Math.max(maxSum, windowSum);
        }  
        //Finds avaerage with k
        //and converts to double
        return (double) maxSum / k;   
    }
}