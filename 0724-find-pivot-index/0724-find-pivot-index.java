class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sumLeft = new int[n];
        int[] sumRight = new int[n];

        int previous = 0;
        int next = 0;
        for(int i = 0; i < n; i++) {
            previous += nums[i];
            sumLeft[i] = previous;
        }

        for(int i = n-1; i >= 0; i--) {
            next += nums[i];
            sumRight[i] = next; 
        }
        
        for(int i = 0; i < n; i++) {
            if(sumLeft[i] == sumRight[i])
                return i;
        }
        return -1;
    }
}