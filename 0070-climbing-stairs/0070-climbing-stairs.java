//Dynamic Programming with Two Variable Linear Approach
//same as Fibonacci Number
class Solution {
       public int climbStairs(int n) {
        if(n <= 2)  return n;
        int past = 1;          //only one single possible case
        int prev = 2;          //for two possible case to reach staircase
        int cur = 0;

        for(int i = 3; i <= n; i++){
            cur = past + prev;
            past = prev;
            prev = cur;
        }
        return cur;
    }
}