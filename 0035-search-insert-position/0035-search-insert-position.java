//Binary Search With Divide & Conquer Approach
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int idx = -1;

        while(left <= right) {
            //Prevents Integer Overflow
            int mid = left + (right - left) / 2;
            
            //Base case for searchinh
            if(nums[mid] == target)
               return mid;
            
            //Go to Right Sub-half
            else if(nums[mid] < target) 
                left = mid + 1;

            //Goes to Left Sub-half
            else if(nums[mid] >= target) 
                right = mid - 1;
        }
        return left;
    }
}