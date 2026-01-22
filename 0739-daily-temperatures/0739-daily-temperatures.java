class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = n-1; i>= 0; i--) {
            //stack is not Monotonic Increaing stack then pop
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if(!stack.isEmpty())
                result[i] = stack.peek() - i;     //finds length btw 
            
            stack.push(i);                        //Adds index to stack
        }
        return result;
    }
}