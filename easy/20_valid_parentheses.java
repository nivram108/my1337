//TAG Stack
class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(brackets.empty()) brackets.push(c);
            else if (isPair(brackets.peek(), c)) brackets.pop();
            else brackets.push(c);
        }
        return brackets.empty();
    }

    boolean isPair(char c1, char c2) {
        if(c1 == '(' && c2 == ')') return true;
        else if(c1 == '[' && c2 == ']') return true;
        else if(c1 == '{' && c2 == '}') return true;
        return false;
    }
}
