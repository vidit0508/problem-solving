package src.main.java.companywise.google.easy;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if (currChar == '(' || currChar == '{' || currChar == '[') {
                stack.add(currChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character prevChar = stack.peek();

                if ((prevChar == '(' && currChar  != ')')
                        || (prevChar == '{' && currChar  != '}')
                        || (prevChar == '[' && currChar  != ']')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
