class Solution {
    int[] memo = new int[501];
    public int minCost(int n) {
        //BASE CASE: Recursion
        if(n == 1)    return 0;

        //Memoization for Repeated Computation for same work
        if(memo[n] != 0)    return memo[n];

        int a = n/2;
        int b = n-a;

        memo[n] = a * b + minCost(a) + minCost(b);
        return memo[n];
    }
}