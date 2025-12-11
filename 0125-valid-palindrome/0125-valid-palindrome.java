class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty())  return true;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch) || Character.isDigit(ch)){
                sb.append(Character.toUpperCase(ch));
            }
        }

        String temp = sb.toString();
        int left = 0, right = temp.length()-1;

        while(left <= right){
            if(temp.charAt(left) != temp.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}