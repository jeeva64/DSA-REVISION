class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sumEven = 0;

        //Computes n +ve odd and even sums
        for(int num = 1; num <= 2 * n; num++) {
            if(num % 2 == 0)
                sumEven += num;
            else
                sumOdd += num;
        }
        return getGcd(sumOdd, sumEven);
    }
    private int getGcd(int a, int b) {
        if(b == 0)      return a;
        return getGcd(b, a % b);
    }
}