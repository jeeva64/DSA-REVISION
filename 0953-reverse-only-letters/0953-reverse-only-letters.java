class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chArr = s.toCharArray();
        int start = 0, end = s.length()-1;

        //Two Pointer Approach
        while(start < end){
            if(Character.isLetter(chArr[start])){
                if(Character.isLetter(chArr[end])){
                    //swaps
                    char temp = chArr[start];
                    chArr[start] = chArr[end];
                    chArr[end] = temp;

                    start++;
                    end--;
                }else{
                    end--;
                }
            }else{
                start++;
            }
        }
        return new String(chArr);
    }
}