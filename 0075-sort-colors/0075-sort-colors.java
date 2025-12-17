class Solution {
    public void sortColors(int[] nums) {
        //Three Poiter Approach with Dutch National Flag Algorithm
        int low = 0, mid = 0, high = nums.length-1;

        while(mid <= high){
            //for blue color to be placed at the end
            if(nums[mid] == 2){
                swap(nums, mid, high--);
            }
            //for red color to be placed at the front
            else if(nums[mid] == 0){
                swap(nums, low++, mid++);
            }
            //move, for failing
            else{
                mid++;
            }
        }
    }
    private static void swap(int[] nums, int low, int high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}