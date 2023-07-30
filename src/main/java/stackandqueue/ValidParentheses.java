package src.main.java.stackandqueue;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        boolean res = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if (currChar == '(' || currChar == '[' || currChar == '{') {
                stack.add(currChar);
            } else {
                if (stack.isEmpty()) {
                    res = false;
                    break;
                }
                Character prevChar = stack.pop();
                if ((prevChar == '(' && currChar != ')')
                        || (prevChar == '{' && currChar != '}')
                        || (prevChar == '[' && currChar != ']')) {
                    res = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            res = false;
        }
        return res;
    }
}
