package io.github.vlad324.n784;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/letter-case-permutation/"}
 */
class Solution {
    public List<String> letterCasePermutation(String s) {
        final var result = new ArrayList<String>();
        permute(0, s.toCharArray(), result);
        return result;
    }

    private void permute(int i, char[] chars, List<String> result) {
        if (i == chars.length) {
            result.add(new String(chars));
            return;
        }

        if (Character.isLowerCase(chars[i])) {
            chars[i] = (char) (chars[i] - 32);
            permute(i + 1, chars, result);
            chars[i] = (char) (chars[i] + 32);
        } else if (Character.isUpperCase(chars[i])) {
            chars[i] = (char) (chars[i] + 32);
            permute(i + 1, chars, result);
            chars[i] = (char) (chars[i] - 32);
        }

        permute(i + 1, chars, result);
    }
}
