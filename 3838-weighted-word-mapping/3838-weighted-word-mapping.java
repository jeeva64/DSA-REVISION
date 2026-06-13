class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        //Reversed Alphanbets
        char[] resChar = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        StringBuilder sb = new StringBuilder();

        for(String word : words) {
            int weightSum = 0;
            //ASCII Index Conversion within 26
            for(char ch : word.toCharArray()) 
                weightSum += weights[ch - 'a'];

            int idx = weightSum % 26;
            sb.append(resChar[idx]);
        }

        return sb.toString();
    }
}