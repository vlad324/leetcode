package io.github.vlad324.n721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/accounts-merge/"}
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final var graph = new HashMap<String, Set<String>>();
        for (final var a : accounts) {
            final var firstEmail = a.get(1);
            for (int j = 2; j < a.size(); j++) {
                final var currentEmail = a.get(j);
                graph.computeIfAbsent(firstEmail, (k) -> new HashSet<>())
                    .add(currentEmail);
                graph.computeIfAbsent(currentEmail, (k) -> new HashSet<>())
                    .add(firstEmail);
            }
        }

        final var processedEmails = new HashSet<String>();
        final var result = new ArrayList<List<String>>();
        for (final var a : accounts) {
            if (processedEmails.contains(a.get(1))) {
                continue;
            }

            final var subList = new ArrayList<String>();
            subList.add(a.get(0));
            populateAllEmails(graph, a.get(1), processedEmails, subList);
            Collections.sort(subList.subList(1, subList.size()));
            result.add(subList);
        }

        return result;
    }

    private void populateAllEmails(Map<String, Set<String>> graph, String start, Set<String> processedEmails, List<String> result) {
        if (processedEmails.contains(start)) {
            return;
        }

        processedEmails.add(start);
        result.add(start);
        for (final var e : graph.getOrDefault(start, Collections.emptySet())) {
            populateAllEmails(graph, e, processedEmails, result);
        }
    }
}
