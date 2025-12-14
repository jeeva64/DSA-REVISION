class Solution {
    public String reverseWords(String s) {
        String[] arrS = s.split(" ");
        StringBuilder res = new StringBuilder();
        res.append(arrS[0]);
        int vowelCnt = vowelCheck(arrS[0]);
        
        for(int i = 1; i < arrS.length; i++){
            String word = arrS[i];
            res.append(" ");
            int curCnt = vowelCheck(word);
            if(vowelCnt == curCnt){
                String rer = reverse(word);
                res.append(rer);
            }else{
                res.append(word);
            }
        }
        return res.toString();
    }
    private String reverse(String word){
        int n = word.length(), z = 0;
        char[] res = new char[n];
        for(int i = n-1; i >= 0; i--){
            res[z++] = word.charAt(i);
        }
        return new String(res);
    }
    private int vowelCheck(String word){
        int cnt = 0;
        for(char ch : word.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                cnt++;
            }
        }
        return cnt;
    }
}