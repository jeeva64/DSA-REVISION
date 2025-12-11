class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //Hashing
        int[] freq = new int[128];

        //Populate magazine frequency 
        for(char c : magazine.toCharArray()){
            //converts ch by ASCII
            freq[c - '0']++;
        }

        //decrement ransomNote in freq 
        for(char c : ransomNote.toCharArray()){
            freq[c - '0']--;
        }

        for(int count : freq){
            if(count < 0) return false;
        }
        return true;
    }
}