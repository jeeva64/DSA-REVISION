class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = BinarySearch(nums, target);

        //If target not found (or) start out of bound index
        if(start == nums.length || nums[start] != target)   return new int[]{-1, -1};

        //Finds target+1 element index and decrement by -1 to get last occurence of duplicate values
        return new int[]{start, BinarySearch(nums, target + 1) - 1};
    }
    private int BinarySearch(int[] nums, int target){
        //right will be out of index that is n
        int left = 0, right = nums.length;

        while(left < right){        //For finding lower bounds, no =
            int mid = left + (right - left) / 2;

            if(nums[mid] < target){
                //Moves to right half part
                left = mid + 1;
            } else{
                //Moves to left half part, inclusive of mid again
                right = mid;
            }
        }
        return left;
    }
}