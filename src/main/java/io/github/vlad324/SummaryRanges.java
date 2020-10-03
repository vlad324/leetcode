package io.github.vlad324;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    private static final String ARROW = "->";

    public List<String> summaryRanges(int[] nums) {
        final var result = new LinkedList<String>();
        for (int i = 0; i < nums.length; i++) {
            final var start = nums[i];

            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }

            if (start != nums[i]) {
                result.add(start + ARROW + nums[i]);
            } else {
                result.add(Integer.toString(start));
            }
        }

        return result;
    }
}
