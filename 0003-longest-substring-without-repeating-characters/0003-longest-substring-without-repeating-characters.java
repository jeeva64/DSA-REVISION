class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0, maxLen = 0;

        //SLIDING WINDOW: Dynamic shrink happens based on valid conditions
        while(end < s.length()) {
            char ch = s.charAt(end);

            if(!set.contains(ch)) {
                //Adds val to Window
                set.add(ch);
                end++;
                //Finds maximum longest substring length without repeating characters
                maxLen = Math.max(maxLen, set.size());
            } else {
                //Remove Start of Window
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLen;

    }
}