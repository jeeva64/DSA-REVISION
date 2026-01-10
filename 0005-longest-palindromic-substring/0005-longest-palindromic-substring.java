class Solution {
    public String longestPalindrome(String s) {
        int start = 0, maxLen = 0;

        for(int i = 0; i < s.length(); i++) {
            int oddLen = expandPalindromic(s, i, i);
            int evenLen = expandPalindromic(s, i, i+1);
            int len = Math.max(oddLen, evenLen);

            if(len > maxLen) {
                maxLen = len;
                //mathematic formula to find index of palindromic substring
                start = i - (maxLen-1) / 2;
            }
        }
        return s.substring(start, start+maxLen);
    }
    private int expandPalindromic(String s, int left, int right) {
        //middle to start & end Type of Two Pointer
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            //Alternative pointer moves upto left == right
            left--;
            right++;
        }
        //finds length of that palindromic substring
        return right - left - 1;
    }
}