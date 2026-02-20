class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) return result;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        generate(result, digits, "", map);
        return result;
    }

    private void generate(List<String> result, String digits, String current, String[] map) {
        //BASE CONDITION
        if(digits.length() == current.length()) {
            result.add(current);
            return;
        }

        //Compute index of digits for iterating over each num
        int pos = current.length();
        int digit = digits.charAt(pos) - '0';   //finds digit one by one
        String letters = map[digit];            //finds that digit's mapped letters
        
        for (char c : letters.toCharArray()){
            generate(result, digits, current + c, map);
        }
    }
}