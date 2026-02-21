class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        //Finds Pivot Element
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }

        //For Pivot element in nums
        if(pivot == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        //Finds biggest num from last to swap with pivot 
        for(int i = n-1; i > pivot; i--) {
            if(nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }
    
        reverse(nums, pivot+1, n-1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start++, end--);
        }
    }
}