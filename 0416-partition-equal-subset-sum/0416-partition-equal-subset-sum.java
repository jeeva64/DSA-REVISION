//DP With Memoization (Top Down Approach)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, total = 0;
        for(int num : nums)     total += num;       //Finds Array Sum

        //Edge case for not same equal subset sum
        if(total % 2 != 0)  return false;

        int target = total / 2;
        //For Memoization
        Boolean[][] memo = new Boolean[n][target+1];

        return checkEqualSubsetSum(nums, n-1, memo, target);
    }
    private boolean checkEqualSubsetSum(int[] nums, int index, Boolean[][] memo, int target) {
        //Base Case for Recursion
        if(target == 0)     return true;
        if(index == 0)      return nums[index] == target;

        //Memoizated Pruning
        if(memo[index][target] != null)     return memo[index][target];

        boolean pick = false;
        boolean nonPick = checkEqualSubsetSum(nums, index-1, memo, target);

        //Picks only, If num less than target
        //and decrement target
        if(nums[index] <= target)
            pick = checkEqualSubsetSum(nums, index-1, memo, target - nums[index]);

        return memo[index][target] = pick || nonPick;
    }
}