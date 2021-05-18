package io.github.vlad324.n609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/find-duplicate-file-in-system/"}
 */
class Solution {

    private static final char CONTENT_START = '(';
    private static final char CONTENT_END = ')';

    public List<List<String>> findDuplicate(String[] paths) {
        final var contentToPath = new HashMap<String, List<String>>();

        final var result = new ArrayList<List<String>>();
        for (final String path : paths) {
            var spaceIndex = path.indexOf(' ');
            final var basePath = path.substring(0, spaceIndex) + "/";

            while (true) {
                final var contentStart = path.indexOf(CONTENT_START, spaceIndex);
                if (contentStart == -1) {
                    break;
                }

                final var contentEnd = path.indexOf(CONTENT_END, contentStart);

                final var filePath = basePath + path.substring(spaceIndex + 1, contentStart);
                final var content = path.substring(contentStart + 1, contentEnd);

                final var sameContentPaths = contentToPath.computeIfAbsent(content, (c) -> new ArrayList<>());
                sameContentPaths.add(filePath);
                if (sameContentPaths.size() == 2) {
                    result.add(sameContentPaths);
                }

                spaceIndex = contentEnd + 1;
            }
        }

        return result;
    }
}
