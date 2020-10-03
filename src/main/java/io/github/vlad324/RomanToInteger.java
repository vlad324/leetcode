package io.github.vlad324;

import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/roman-to-integer/"}
 */
public class RomanToInteger {

    private static final Map<Character, Integer> MAPPING = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    public int romanToInt(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Passed string is not valid");
        }

        int result = 0;
        int previous = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = MAPPING.get(s.charAt(i));
            result += current;
            if (current > previous) {
                result -= 2 * previous;
            }
            previous = current;
        }

        return result;
    }
}
