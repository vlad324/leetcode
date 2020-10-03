package io.github.vlad324;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .sorted((e1, e2) -> {
                final var countCompare = Long.compare(e2.getValue(), e1.getValue());
                return countCompare == 0 ? e1.getKey().compareTo(e2.getKey()) : countCompare;
            })
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
