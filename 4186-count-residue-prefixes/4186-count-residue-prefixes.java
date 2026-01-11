class Solution {
    public int residuePrefixes(String s) {
        int count = 0, condition;
        String prefix = new String();
        Set<Character> distinctChar = new HashSet();
        
        for(char ch : s.toCharArray()) {
            distinctChar.add(ch);
            prefix += ch;
            condition = prefix.length() % 3;
            if(distinctChar.size() == condition) 
                count++;
        }
        return count;
    }
}