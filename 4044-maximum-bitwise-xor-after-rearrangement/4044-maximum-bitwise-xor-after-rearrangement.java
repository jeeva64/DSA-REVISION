class Solution {
    public String maximumXor(String s, String t) {
        int zeros = 0, ones = 0;
        StringBuilder sb = new StringBuilder();

        for(char digit : t.toCharArray()) {
            if(digit == '1')    ones++;
            else if(digit == '0')    zeros++;
        }

        for(int i = 0; i < s.length(); i++) {
            char s_digit = s.charAt(i);

            if(s_digit == '0') {
                 if (ones > 0) {
                    sb.append('1'); 
                    ones--;
                } else {
                    sb.append('0'); 
                    zeros--;
                }
            }
            else {
                if (zeros > 0) {
                    sb.append('1'); 
                    zeros--;
                } else {
                    sb.append('0'); 
                    ones--;
                }
            }
        }
        return sb.toString();
    }
}