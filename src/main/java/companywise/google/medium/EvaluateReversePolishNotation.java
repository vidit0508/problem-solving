package src.main.java.companywise.google.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            Integer one = 0;
            Integer two = 0;

            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    two = stack.pop();
                    one = stack.pop();
                    stack.push(one - two);
                    break;
                case "*":
                    two = stack.pop();
                    one = stack.pop();
                    stack.push(one * two);
                    break;
                case "/":
                    two = stack.pop();
                    one = stack.pop();
                    stack.push(one / two);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
