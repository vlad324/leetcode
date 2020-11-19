package io.github.vlad324.n394;

/**
 * {@link "https://leetcode.com/problems/decode-string/"}
 */
class Solution {
    public String decodeString(String s) {
        return decodeString(s, -1, s.length());
    }

    public String decodeString(String s, int start, int end) {
        var result = new StringBuilder();
        for (int i = start + 1; i < end; i++) {
            final var c = s.charAt(i);
            if (Character.isLetter(c)) {
                result.append(c);
            } else if (Character.isDigit(c)) {
                final var bStart = findOpeningBracketIndex(s, i);
                final var bEnd = findClosingBracketIndex(s, bStart);
                final var decodedString = decodeString(s, bStart, bEnd);

                final var count = Integer.parseInt(s, i, bStart, 10);
                result.append(decodedString.repeat(count));

                i = bEnd;
            }
        }

        return result.toString();
    }

    private int findOpeningBracketIndex(String s, int i) {
        while (s.charAt(i) != '[') {
            i++;
        }

        return i;
    }

    private int findClosingBracketIndex(String s, int i) {
        int count = 0;
        do {
            if (s.charAt(i) == '[') {
                count++;
            } else if (s.charAt(i) == ']') {
                count--;
            }
            i++;
        } while (count > 0);

        return i - 1;
    }
}
