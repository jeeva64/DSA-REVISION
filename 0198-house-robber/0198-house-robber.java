//Greedy DP With Two Variable -> TC == O(N) && SC == O(1)
class Solution {
    public int rob(int[] nums) {
        //Edge Cases
        int n = nums.length;
        if(n == 0)      return 0;
        if(n == 1)      return nums[0];

        //For Two Variable DP
        int prev2 = 0, prev1 = 0;
        int cur = 0;

        for(int num : nums) {
            //Pick & Non Pick Choice
            int pick = num + prev2;
            int nonPick = 0 + prev1;
            cur = Math.max(pick, nonPick);

            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}