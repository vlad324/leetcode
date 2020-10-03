package io.github.vlad324;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@link "https://leetcode.com/problems/sort-characters-by-frequency/"}
 */
public class CharacterSort {
    public String frequencySort(String s) {
        return s.chars()
            .mapToObj(i -> (char) i)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .sorted((e1, e2) -> {
                final var countComparison = Long.compare(e2.getValue(), e1.getValue());
                return countComparison == 0 ? Character.compare(e2.getKey(), e1.getKey()) : countComparison;
            })
            .collect(StringBuilder::new, (sb, e) -> append(sb, e.getKey(), e.getValue()), StringBuilder::append)
            .toString();
    }

    private static void append(StringBuilder sb, Character c, Long count) {
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
    }
}
