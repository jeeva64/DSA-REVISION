class Solution {
    public String reversePrefix(String s, int k) {
        if(k <= 1) return s;
        char[] chArr = s.toCharArray();
        int left = 0, right = k-1;

        while(left <= right) {
            char ch = chArr[left];
            chArr[left] = chArr[right];
            chArr[right] = ch;
            left++;
            right--;
        }
        return String.valueOf(chArr);
    }
}