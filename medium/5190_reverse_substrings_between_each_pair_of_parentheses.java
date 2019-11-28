class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        String ans = "";
        List<Integer> left
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ')' && s.charAt(i) != '(') len++;
        }

        while(ans.length() != len) {

        }
    }
}
