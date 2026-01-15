class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1, num2;

        for(String token : tokens) {
            switch(token) {
                //Gets the Immediate two num before + and push sum to stack
                case "+" -> stack.push(stack.pop() + stack.pop());
                //Gets the Immediate two num before * and push mul to stack
                case "*" -> stack.push(stack.pop() * stack.pop());
                //Gets the Immediate two num before - and push sub to stack
                case "-" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                }
                //Gets the Immediate two num before / and push div to stack
                case "/" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                }
                //If it is num, then typecast to int into stack
                default -> stack.push(Integer.parseInt(token));
            }
        }
        //return result in stack
        return stack.pop();
    }
}