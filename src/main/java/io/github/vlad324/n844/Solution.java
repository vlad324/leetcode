package io.github.vlad324.n844;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/backspace-string-compare/"}
 */
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return compare(toStack(s), toStack(t));
    }

    private Stack<Character> toStack(String s) {
        final var stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (c != '#') {
                stack.add(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack;
    }

    private boolean compare(Stack<Character> s1, Stack<Character> s2) {
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }

        return s1.isEmpty() && s2.isEmpty();
    }
}
