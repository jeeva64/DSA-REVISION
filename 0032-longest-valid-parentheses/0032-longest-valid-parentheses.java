//TIME & SPACE COMPLEXITY: O(N)
class Solution {
    public int longestValidParentheses(String s) {
        //Stack Stores Index of the ( brackets
        Stack<Integer> stack = new Stack<>();
        int left = -1, max = 0;

        for(int idx = 0; idx < s.length(); idx++) {
            //If it is ( then Store its index for finding well formed length
            if(s.charAt(idx) == '(') 
                stack.push(idx);
            else {
                //If stack empty, left pointer moves to index after valid well formed bracket
                if(stack.isEmpty())
                    left = idx;
                //else, finds the maximum length of valid parenthesis
                else {
                    stack.pop();
                    //if stack empty, compute length from left to idx. so subtracting it.
                    if(stack.isEmpty())
                        max = Math.max(max, idx - left);
                    //else, finds length from next ( parenthesis index stored in stack to idx. so sub it.
                    else
                        max = Math.max(max, idx - stack.peek());
                }
            }
        }
        //return max valid parenthesis
        return max;
    }
}