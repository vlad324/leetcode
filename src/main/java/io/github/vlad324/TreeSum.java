package io.github.vlad324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        final var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        final var result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        final var set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    final var diff = -nums[i] - nums[j];
                    if (set.contains(diff)) {
                        result.add(List.of(nums[i], diff, nums[j]));
                        while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                            j++;
                        }
                    } else {
                        set.add(nums[j]);
                    }
                }
                set.clear();
            }
        }

        return result;
    }
}
