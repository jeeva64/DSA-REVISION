class Solution {
    public String reverseByType(String s) {
        if(s.length() <= 1)   return s;
        StringBuilder letters = new StringBuilder();
        StringBuilder symbols = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(Character.isLetter(ch))
                letters.append(ch);
            else
                symbols.append(ch);
        }
        String letterRes = letters.reverse().toString();
        String symbolRes = symbols.reverse().toString();
        int li = 0, si = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetter(ch))
                result.append(letterRes.charAt(li++));
            else
                result.append(symbolRes.charAt(si++));
                
        }
        return result.toString();
    }
}