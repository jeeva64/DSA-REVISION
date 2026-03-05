class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxWindow = 0, maxFreq = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            //POPULATE: Freq for the current character
            freq[ch-'A']++;

            //COMPUTE: Max Frequency seen so far
            maxFreq = Math.max(maxFreq, freq[ch-'A']);

            //FIND: MaxWindow with valid longest repeating character after replacement
            int curWindow = right - left + 1;
            
            //CHECKS: K times replacement only
            int charNeedsToBeChanged = curWindow - maxFreq;
            
            //SHRINK: Window size for Invalid cases
            if(charNeedsToBeChanged > k) {
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxWindow = Math.max(maxWindow, right-left+1);
        }
        return maxWindow;
    }
}