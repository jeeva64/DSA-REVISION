class Solution {
    public int singleNonDuplicate(int[] nums) {
        //Right will be previous element of last element in nums
        //For single element present at the last index
        int low = 0, high = nums.length-2;

        while(low <= high){
            int mid = low + (high - low) / 2;

            //If  odd index first & even index second will be left half of single element
            //else, even index first & odd index second will be right half of single element
            if(nums[mid] == nums[mid ^ 1]){
                //Moves to right half
                low = mid + 1;
            } else {
                //Moves to left half
                high = mid - 1;
            }
        }
        return nums[low];
    }
}