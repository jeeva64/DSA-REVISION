//DP with Tabulation Approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1)
            return 0;

        //DP for Tabulation 
        int[] mincoinDP = new int[amount+1];
        int maxLimit = Integer.MAX_VALUE;

        for(int amt = 1; amt <= amount; amt++) {
            //For Edge case
            mincoinDP[amt] = maxLimit;

            for(int coin : coins) {
                //Amount is decremented by the coins array unlimitedly
                if(coin <= amt && mincoinDP[amt - coin] != maxLimit) {
                    //Minimum Possible coin change
                    mincoinDP[amt] = Math.min(mincoinDP[amt], 1 + mincoinDP[amt - coin]);
                }
            }
        }
        //If there is no valid coil change
        return mincoinDP[amount] == maxLimit ? -1 : mincoinDP[amount];
    }
}