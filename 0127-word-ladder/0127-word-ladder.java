class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord))     return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int depth = 1;

        //BFS with Neighboring one letter change word 
        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                char[] cur = queue.poll().toCharArray();

                //Replaces all single letter of beginword 
                //to get the next word present in wordlist
                for(int i = 0; i < cur.length; i++) {
                    char orginal = cur[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == orginal)    continue;
                        cur[i] = c;
                        String next = new String(cur);

                        //When endWord is derived then answer will depth+1
                        if(next.equals(endWord))    return depth + 1;
                        //Expands neighbouring words
                        if(dict.contains(next)) {
                            queue.offer(next);
                            dict.remove(next);
                        }
                    }
                    //Undo character change to same as previous character
                    cur[i] = orginal;
                }
            }
            depth++;
        }
        return 0;
    }
}