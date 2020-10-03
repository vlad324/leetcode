package io.github.vlad324.n468;

import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/validate-ip-address/"}
 */
class Solution {

    private static final String NEITHER = "Neither";
    private static final String IPv4 = "IPv4";
    private static final String IPv6 = "IPv6";

    private static final Set<Character> EXPECTED_LETTERS = Set.of('A', 'B', 'C', 'D', 'E', 'F',
        'a', 'b', 'c', 'd', 'e', 'f');

    public String validIPAddress(String ip) {
        if (ip.isEmpty() || ip.length() < 7 || !Character.isLetterOrDigit(ip.charAt(ip.length() - 1))) {
            return NEITHER;
        }

        boolean ipV4 = true;
        for (int i = 0; i < ip.length(); i++) {
            final var c = ip.charAt(i);
            if (!Character.isDigit(c) && c != '.') {
                ipV4 = false;
                if (c != ':' && !EXPECTED_LETTERS.contains(c)) {
                    return NEITHER;
                }
            }
        }

        final var split = ip.split("\\.|:");

        if (ipV4 && split.length == 4) {
            return isValidIPv4(split) ? IPv4 : NEITHER;
        }

        if (split.length == 8) {
            return isValidIPv6(split) ? IPv6 : NEITHER;
        }

        return NEITHER;
    }

    private boolean isValidIPv6(String[] ip) {
        for (String s : ip) {
            if (s.length() < 1 || s.length() > 4) {
                return false;
            }

            try {
                final var i = Integer.parseInt(s, 16);

                if (i < 0 || i > 0xFFFF) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidIPv4(String[] ip) {
        for (String s : ip) {
            if (s.length() < 1 || s.length() > 3) {
                return false;
            }

            try {
                final var i = Integer.parseInt(s, 10);

                if (i > 255 || i < 0) {
                    return false;
                }

                if (i < 10 && s.length() != 1) {
                    return false;
                } else if (10 <= i && i < 100 && s.length() != 2) {
                    return false;
                } else if (100 <= i && s.length() != 3) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
}
