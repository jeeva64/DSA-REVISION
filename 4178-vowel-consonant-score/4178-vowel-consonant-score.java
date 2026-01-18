class Solution {
    public int vowelConsonantScore(String s) {
        int vowels = 0, consonant = 0;
        int score = 0;

        for(char val : s.toCharArray()) {
            if(Character.isLetter(val)) {
                if(val == 'a' || val == 'e' || val == 'i' || val == 'o' || val == 'u')
                    vowels++;
                else
                    consonant++;
            }
        }
        if(consonant > 0)
            score = vowels / consonant;

        return score;
    }
}