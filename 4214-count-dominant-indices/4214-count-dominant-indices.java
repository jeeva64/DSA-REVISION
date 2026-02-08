class Solution {
    public int dominantIndices(int[] nums) {
        int result = 0;
        int prefixSum = 0, rightCnt = 0;
        int n = nums.length;

        for(int num : nums)    
            prefixSum += num;

        for(int i = 0; i < n; i++) {
            prefixSum -= nums[i];
            rightCnt = (n-i-1 != 0) ? (n-i-1) : 1;
            float avg = prefixSum / rightCnt;
            
            if(nums[i] > avg && i != n-1)
                result++;
        }
        return result;
    }
}