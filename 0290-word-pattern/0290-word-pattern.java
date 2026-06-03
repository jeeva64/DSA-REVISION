class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        int n = pattern.length();
        int m = sArr.length;
        //Edge Case
        if(n != m)      return false;

        Map<Character, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String word = sArr[i];

            if(map.containsKey(ch)) {
                //Contains ch & word mismatch in the map
                if(!map.get(ch).equals(word))
                    return false;
            }
            else {
                //Doesn't Contains ch & word matches to other ch in the map
                if(map.containsValue(word))
                    return false;

                //Adds new ch & word to the map
                map.put(ch, word);
            }
        }
        return true;
    }
}