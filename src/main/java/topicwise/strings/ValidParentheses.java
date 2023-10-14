package src.main.java.topicwise.strings;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()(";
        System.out.println(hasValidParentheses(s));
    }

    private static boolean hasValidParentheses(String s) {
        boolean hasValidParentheses = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if ((currChar == '(') || (currChar == '{') || (currChar == '[')) {
                stack.add(currChar);
            } else {
                if (stack.isEmpty()) {
                    hasValidParentheses = false;
                    break;
                }
                Character lastChar = stack.pop();
                if ((currChar == ')' && lastChar != '(')
                        || (currChar == '}' && lastChar != '{')
                        || (currChar == ']' && lastChar != '[')) {
                    hasValidParentheses = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            hasValidParentheses = false;
        }
        return hasValidParentheses;
    }
}
