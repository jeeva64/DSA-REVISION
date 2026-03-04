class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() < p.length())    return result;

        //Array for Frequency count of character by their ASCII Value
        int[] sHash = new int[26];
        int[] pHash = new int[26];
        int left = 0, right = 0;
        int window = p.length();

        //FOR: Initial Window size frequency populations in s & p Hash arrays
        while(right < window) {
            sHash[s.charAt(right) - 'a']++;
            pHash[p.charAt(right) - 'a']++;
            right++;
        }
        right--;    //Due to while loop condition exceeds increment by one

        
        while(right < s.length()) {
            //CHECK: For valid case of initial freq to add in result
            if(Arrays.equals(sHash, pHash)) 
                result.add(left);

            //COMPUTE: New character freq to sHash (Greater than window characters)
            //EXTENDS: Sliding Window by one new charcter at the right in sHash (increment freq)
            if(++right != s.length())
                sHash[s.charAt(right) - 'a']++;

            //SHRINK: Old left Character of the Sliding Window  in sHash (decrement freq)
            sHash[s.charAt(left) - 'a']--;
            left++;
        }
        return result;
    }
}