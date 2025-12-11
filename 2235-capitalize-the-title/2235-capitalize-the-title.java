class Solution {
    public String capitalizeTitle(String title) {
        //convert string into character array & variable for index of first char
        char[] chArr= title.toCharArray();
        int firstIdx = 0, n = chArr.length;
        
        for(int i = 0; i < n; i++){
            firstIdx = i; //stores first
            //Goes upto space for an word
            while(i<n && chArr[i] != ' '){
                //set to lowercase 
                chArr[i] = Character.toLowerCase(chArr[i]);
                i++;
            }

            //if length of word > 2
            if(i - firstIdx > 2){
                //capitalize first char
                chArr[firstIdx] = Character.toUpperCase(chArr[firstIdx]);
            }
        }

        // convert into string 
        return String.valueOf(chArr);
        
    }
}