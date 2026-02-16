class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for(String word : words) {
            //As per Describtions
            if(word.length() < k)  continue;

            //Popluate Frequency of common prefix connected group
            String key = word.substring(0, k);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int result = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            result += (freq > 1) ? 1 : 0;
        }
        return result;
    }
}