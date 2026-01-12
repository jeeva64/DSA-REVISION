class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1)
            return false;
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            //Intuision: If it is (, {, [ then push opposite brackets
            if(ch == '(')
                stack.push(')');
            else if(ch == '{')
                stack.push('}');
            else if(ch == '[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != ch)
                return false;
        } 
        return stack.isEmpty();
    }
}