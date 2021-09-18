package io.github.vlad324.n282;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/expression-add-operators/"}
 */
class Solution {

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }

        final var result = new ArrayList<String>();
        recurse(num.toCharArray(), target, 0, 0, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void recurse(char[] num, int target, int index, long previousOperand, long currentOperand, long value, StringBuilder ops, List<String> result) {
        if (index == num.length) {
            if (value == target && currentOperand == 0) {
                result.add(ops.substring(1, ops.length()));
            }

            return;
        }

        currentOperand = currentOperand * 10 + (num[index] - '0');

        if (currentOperand > 0) {
            recurse(num, target, index + 1, previousOperand, currentOperand, value, ops, result);
        }

        final var initialOpsLength = ops.length();

        ops.append('+').append(currentOperand);
        recurse(num, target, index + 1, currentOperand, 0, value + currentOperand, ops, result);
        ops.delete(initialOpsLength, ops.length());

        if (ops.length() > 0) {
            ops.append('-').append(currentOperand);
            recurse(num, target, index + 1, -currentOperand, 0, value - currentOperand, ops, result);
            ops.delete(initialOpsLength, ops.length());

            ops.append('*').append(currentOperand);
            recurse(num, target, index + 1, currentOperand * previousOperand, 0, value - previousOperand + (currentOperand * previousOperand), ops, result);
            ops.delete(initialOpsLength, ops.length());
        }
    }
}
