class Solution {
    public String minWindow(String s, String t) {
        //SLIDING WINDOW PATTERN
        if(s.length() < t.length())    return "";

        int[] tFreq = new int[128];
        int[] windowFreq = new int[128];
        int left = 0, start = 0, minLen = Integer.MAX_VALUE;

        //POPULATE: tFreq of String t
        for(char ch : t.toCharArray()) 
            tFreq[ch - '0']++;

        for(int right = 0; right < s.length(); right++) {
            //POPULATE: windowFreq by Current window character from s
            windowFreq[s.charAt(right) - '0']++;

            while(containsAll(windowFreq, tFreq)) {
                int windowLen = right - left + 1;

                //Math.min() don't give us the start position of valid substring
                if(windowLen < minLen) {
                    minLen = windowLen;
                    start = left;
                }
                //SHRINK: Window decreses & its frequency too decremented
                windowFreq[s.charAt(left) - '0']--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
    //USED: For finding valid substring
    private boolean containsAll(int[] windowFreq, int[] tFreq) {
        //CONDITION: windowFreq must be >= as per tFreq
        for(int i = 0; i < 128; i++) {
            if(windowFreq[i] < tFreq[i])
                return false;
        }
        return true;
    }
}