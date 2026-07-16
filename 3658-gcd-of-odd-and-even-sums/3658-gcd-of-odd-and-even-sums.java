class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n * n;
        int sumEven = n * (n + 1);
        
        return getGcd(sumOdd, sumEven);
    }
    private int getGcd(int a, int b) {
        if(b == 0)      return a;
        return getGcd(b, a % b);
    }
}