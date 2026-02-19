class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }
    //Recursive method
    private void generate(List<String> res, String pair, int open, int close, int max) {
        //Base Condition
        if(pair.length() == 2*max) {
            res.add(pair);
            return;
        }

        //Adds ( valid open bracket
        if(open < max) {
            generate(res, pair+"(", open+1, close, max);
        }

        //Adds ) valid close bracket
        if(open > close) {
            generate(res, pair+")", open, close+1, max);
        }
    }
}