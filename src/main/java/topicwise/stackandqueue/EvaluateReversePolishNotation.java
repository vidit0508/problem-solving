package src.main.java.topicwise.stackandqueue;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            Integer two = 0;
            Integer one = 0;
            switch(token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    two = stack.pop();
                    one = stack.pop();
                    stack.push(one - two);
                    break;
                case "/":
                    two = stack.pop();
                    one = stack.pop();
                    stack.push(one / two);
                    break;
                case "*":
                    two = stack.pop();
                    one = stack.pop();
                    stack.push(one * two);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
