class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        
        int[] ans = new int[n];
        int[] preMax = new int[n];
        int[] sufMin = new int[n];
       
        //Prefix Array with Maximum values
        preMax[0] = nums[0];
        for(int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }
        
        //Suffix Array with Minimum values
        sufMin[n-1] = nums[n-1];
        for(int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(sufMin[i + 1], nums[i]);
        }
        
        //compute ans
        ans[n-1] = preMax[n-1];
        for(int i = n-2; i >= 0; i--) {
            //Uses previous value 
            if(preMax[i] > sufMin[i+1])
                ans[i] = ans[i+1];

            //Uses new max value
            else
                ans[i] = preMax[i];
        }
        return ans;
    }
}