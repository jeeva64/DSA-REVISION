class Solution {
    //Finonacci Series excluding zero as input
    public int climbStairs(int n) {
        //Edge case with 2 for climbing stairs
        if(n <= 2)      return n;

        int past = 1;
        int prev = 2;
        int result = 0;

        //Start from 3
        for(int i = 3; i <= n; i++) {
            result = past + prev;
            past = prev;
            prev = result;
        }
        return result;
    }
}