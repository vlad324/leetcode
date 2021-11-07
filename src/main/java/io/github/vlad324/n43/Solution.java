package io.github.vlad324.n43;

/**
 * {@link "https://leetcode.com/problems/multiply-strings/"}
 */
class Solution {

    private static final String ZERO = "0";

    public String multiply(String num1, String num2) {
        if (ZERO.equals(num1) || ZERO.equals(num2)) {
            return ZERO;
        }

        int position = 0;
        final var result = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            multiplyInner(result, num1, charToInt(num2.charAt(i)), position);
            position++;
        }

        normalize(result);
        return convertToString(result);
    }

    private void normalize(int[] result) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 9) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
    }

    private void multiplyInner(int[] result, String num, int b, int position) {
        for (int i = num.length() - 1; i >= 0; i--) {
            result[position] += charToInt(num.charAt(i)) * b;
            position++;
        }
    }

    private String convertToString(int[] result) {
        final var builder = new StringBuilder(result.length);
        int i = result.length - 1;
        while (result[i] == 0) {
            i--;
        }
        while (i >= 0) {
            builder.append(result[i]);
            i--;
        }
        return builder.toString();
    }

    private int charToInt(char c) {
        return c - '0';
    }
}
