package io.github.vlad324.n336;

import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/palindrome-pairs/"}
 */
class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
        final var result = new LinkedList<List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                final var isPalindromeIJ = isPalindrome(words[i], words[j]);
                if (isPalindromeIJ) {
                    result.add(List.of(i, j));
                }

                if ((isPalindromeIJ && words[i].length() == words[j].length()) || isPalindrome(words[j], words[i])) {
                    result.add(List.of(j, i));
                }
            }
        }

        return result;
    }

    boolean isPalindrome(String w1, String w2) {
        int start = 0;
        int end = w1.length() + w2.length() - 1;

        while (start < end) {
            if (letter(w1, w2, start) != letter(w1, w2, end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private char letter(String w1, String w2, int index) {
        if (index < w1.length()) {
            return w1.charAt(index);
        }

        return w2.charAt(index - w1.length());
    }
}
