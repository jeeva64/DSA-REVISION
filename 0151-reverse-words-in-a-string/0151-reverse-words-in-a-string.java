class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = s.length();

        while(i < n){
            //search for character
            while(i < n && s.charAt(i) == ' ' ){
                i++;
            }
            if(i >= n) break;
            int j = i + 1;
        //search for space to split word
            while(j < n && s.charAt(j) != ' '){
                j++;
            }
            String sub = s.substring(i,j);

            if(sb.length() == 0){ 
                sb.append(sub);
            }else{
                sb.insert(0, sub + " ");
            }

            i = j + 1;//Jump to next word    
        }
        return sb.toString();
    }
}