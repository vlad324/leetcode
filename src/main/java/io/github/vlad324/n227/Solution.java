package io.github.vlad324.n227;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/basic-calculator-ii/"}
 */
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final var stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = 10 * currentNumber + (c - '0');
            }

            if ((!Character.isDigit(c) && !Character.isSpaceChar(c)) || i == s.length() - 1) {
                switch (operation) {
                    case '+':
                        stack.push(currentNumber);
                        break;
                    case '-':
                        stack.push(-currentNumber);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNumber);
                        break;
                    case '/':
                        stack.push(stack.pop() / currentNumber);
                        break;
                }

                operation = c;
                currentNumber = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
