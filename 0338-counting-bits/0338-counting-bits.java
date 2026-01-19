class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for(int i = 0; i <= n; i++) {
            //For odd index numbers 
            if(i % 2 != 0)
                result[i] = result[i/2]+1;
            else
                result[i] = result[i/2];
        }

        return result;
    }
}