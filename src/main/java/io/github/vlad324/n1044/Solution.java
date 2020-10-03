package io.github.vlad324.n1044;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/longest-duplicate-substring/"}
 */
class Solution {

    private static final int D = 26;
    private static final int P = 108881;

    public String longestDupSubstring(String s) {
        int maxLength = s.length() - 1;
        int minLength = 1;
        String result = "";
        while (maxLength >= minLength) {
            int mid = minLength + (maxLength - minLength) / 2;
            final var substring = findAtLeastTwoSubstring(s, mid);

            if (substring != null) {
                minLength = mid + 1;
                result = substring;
            } else {
                maxLength = mid - 1;
            }
        }

        return result;
    }

    private String findAtLeastTwoSubstring(String s, int length) {
        int h = 1;
        for (int i = 0; i < length - 1; i++) {
            h = (h * D) % P;
        }

        final var hashes = new HashMap<Integer, List<Integer>>();
        int windowHash = 0;
        for (int i = 0; i < length; i++) {
            windowHash = (D * windowHash + s.charAt(i)) % P;
        }

        addStartNumber(hashes, windowHash, 0);
        for (int i = 1; i <= s.length() - length; i++) {
            windowHash = (D * (windowHash - s.charAt(i - 1) * h) + s.charAt(i - 1 + length)) % P;

//            if (windowHash < 0) {
//                windowHash += P;
//            }

            final var start = hashes.get(windowHash);
            if (start != null && anySubstringEquals(s, start, i, length)) {
                return s.substring(i, i + length);
            }

            addStartNumber(hashes, windowHash, i);
        }

        return null;
    }

    private void addStartNumber(Map<Integer, List<Integer>> hashes, int windowHash, int start) {
        if (hashes.containsKey(windowHash)) {
            hashes.get(windowHash).add(start);
        } else {
            final var starts = new LinkedList<Integer>();
            starts.add(start);
            hashes.put(windowHash, starts);
        }
    }

    private boolean anySubstringEquals(String s, List<Integer> starts, int j, int maxLength) {
        return starts.stream().anyMatch(start -> substringEquals(s, start, j, maxLength));
    }

    private boolean substringEquals(String s, int i, int j, int maxLength) {
        for (int k = 0; k < maxLength; k++) {
            if (s.charAt(i + k) != s.charAt(j + k)) {
                return false;
            }
        }

        return true;
    }
}
