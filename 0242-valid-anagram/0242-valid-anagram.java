class Solution {
    public boolean isAnagram(String s, String t) {
        //Invalid Condition
        if(s.length() != t.length())    return false;

        //For Frequency, similiar to Hashmap
        int[] hash = new int[128];

        //populate hash with s frequency
        for(char ch : s.toCharArray()) {
            hash[ch]++;
        }

        //Decrement t frequency in hash
        for(char ch : t.toCharArray()) {
            hash[ch]--;
        }

        //check hash
        for(int freq : hash) {
            if(freq > 0)
                return false;
        }
        return true;
    }
}