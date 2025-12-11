class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 0)      return;                    //Prune nums is empty
        k %= n;                                    //Optimization for k >= n will be repeated
        reverseArray(nums, 0, n-1);                 
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, n-1);
    }
    private static void reverseArray(int[] nums, int left, int right){
        int temp = 0;
        while(left <= right){                       //Two Pointer Approach
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}