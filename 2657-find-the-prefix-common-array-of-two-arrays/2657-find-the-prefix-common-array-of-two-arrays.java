class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        //Running Prefix Frequency
        int prefixFreq = 0;
        int n = A.length;
        
        //Map for Frequency & result array for output
        Map<Integer, Integer> freq = new HashMap<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            //Populate A's element and check frequency 2
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
            if(freq.get(A[i]) == 2) 
                prefixFreq += 1;

            //Populate B's element and check frequency 2
            freq.put(B[i], freq.getOrDefault(B[i], 0) + 1);
            if(freq.get(B[i]) == 2) 
                prefixFreq += 1;

            //stores prefixFreq to the result
            result[i] = prefixFreq;
        }
        return result;
    }
}