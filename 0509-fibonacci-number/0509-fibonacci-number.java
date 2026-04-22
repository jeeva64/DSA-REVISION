class Solution {
    public int fib(int n) {
        //Edge Case
        if(n <= 1)      return n;
        //2 Variable linear Approach in the DP
        int previous = 0, current = 1;
        int result = 0;

        for(int i = 2; i <= n; i++) {
            result = previous + current;
            previous = current;
            current = result;
        }
        return result;
    }
}