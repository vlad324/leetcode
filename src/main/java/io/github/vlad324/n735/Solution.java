package io.github.vlad324.n735;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/asteroid-collision/"}
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length < 2) {
            return asteroids;
        }

        final var stack = new Stack<Integer>();
        for (final int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }

            final int currentSize = Math.abs(asteroid);
            while (!stack.isEmpty() && 0 < stack.peek() && stack.peek() < currentSize) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            } else if (stack.peek() == currentSize) {
                stack.pop();
            }
        }

        final var result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
