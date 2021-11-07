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

        final var result = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            multiplyInner(result, num1, charToInt(num2.charAt(i)), num2.length() - 1 - i);
        }

        return convertToString(result);
    }

    private void multiplyInner(int[] result, String num, int b, int position) {
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int m = charToInt(num.charAt(i)) * b + carry;

            carry = m / 10;

            result[position] += m % 10;
            if (result[position] > 9) {
                carry++;
                result[position] %= 10;
            }
            position++;
        }

        while (carry != 0) {
            result[position] += carry;
            carry = 0;
            if (result[position] > 9) {
                carry++;
                result[position] %= 10;
            }
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
