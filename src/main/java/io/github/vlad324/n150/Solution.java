package io.github.vlad324.n150;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/evaluate-reverse-polish-notation/"}
 */
class Solution {
    public int evalRPN(String[] tokens) {
        final var stack = new Stack<Integer>();
        for (final String token : tokens) {
            int k;
            switch (token) {
                case "+":
                    k = stack.pop() + stack.pop();
                    break;
                case "*":
                    k = stack.pop() * stack.pop();
                    break;
                case "-":
                    int a = stack.pop();
                    k = stack.pop() - a;
                    break;
                case "/":
                    int b = stack.pop();
                    k = stack.pop() / b;
                    break;
                default:
                    k = Integer.parseInt(token);
            }
            stack.push(k);
        }

        return stack.pop();
    }
}
