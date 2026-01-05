class Solution {
    public int[] sortedSquares(int[] nums) {
        //Two Pointer Approach
        int n = nums.length;
        int left = 0, right = n-1;
        int[] result = new int[n];

        for(int i = n-1; i >= 0; i--) {
            //Checks for left pointer value is largest number
            //its square is added at the end result
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            }
            else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}