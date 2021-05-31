package io.github.vlad324.n1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/search-suggestions-system/"}
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        final var root = new Node();
        for (final var p : products) {
            var n = root;
            for (int i = 0; i < p.length(); i++) {
                n = n.children.computeIfAbsent(p.charAt(i), c -> new Node());

                if (n.words.size() < 3) {
                    n.words.add(p);
                }
            }
        }

        final var result = new ArrayList<List<String>>(searchWord.length());
        var n = root;
        for (int i = 0; i < searchWord.length(); i++) {
            n = n.children.getOrDefault(searchWord.charAt(i), new Node());
            result.add(n.words);
        }

        return result;
    }

    private static class Node {
        public Map<Character, Node> children = new HashMap<>();
        public List<String> words = new ArrayList<>();
    }
}


