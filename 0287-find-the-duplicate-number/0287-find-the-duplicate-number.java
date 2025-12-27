class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length-1;

        //Modified Binary Search without =
        while(left < right){
            int mid = left + (right - left) / 2;

            //Finds each left half length and
            //compare with mid to check duplicate number in it
            int count = 0;
            for(int num : nums){
                if(num <= mid){
                    count++;
                }
            }

            //If there is more than mid index then 
            //move to that left half
            if(count > mid){
                right = mid;
            } 
            else{
                //else goto right half
                left = mid + 1;
            }
        }
        return left;
    }
}