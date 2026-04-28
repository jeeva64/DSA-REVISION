//Greedy DP, But uses Greedy to solve Intuitively
class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        //Maintains maximum possible index to reach the end
        for(int i = 0; i < nums.length; i++) {
            //there is no choice to reach the end of the array
            if(i > farthest)    return false;
            //use all possible jump choices in nums
            farthest = Math.max(farthest, nums[i] + i);
        }
        return true;
    }
}