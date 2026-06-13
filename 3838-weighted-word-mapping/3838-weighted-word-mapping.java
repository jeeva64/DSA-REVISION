class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] resChar = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        StringBuilder res = new StringBuilder();
        
        Map<Character, Integer> mapIdx = new HashMap<>();
        int idx = 0;
        for(char c = 'a'; c <= 'z'; c++) {
            mapIdx.put(c, idx++);
        }

        for(String word : words) {
            int weight = 0;
            for(char ch : word.toCharArray()) {
                int index = mapIdx.get(ch);
                weight += weights[index];
            }
            res.append(resChar[weight % 26]);
            weight = 0;
        }

        return res.toString();
    }
}