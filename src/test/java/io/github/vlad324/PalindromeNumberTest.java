package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PalindromeNumberTest {

    private final PalindromeNumber palindromeNumber = new PalindromeNumber();


    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int number, boolean palindrome) {
        // when
        final var actual = palindromeNumber.isPalindrome(number);

        // then
        assertThat(actual).isEqualTo(palindrome);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(0, true),
            arguments(121, true),
            arguments(-121, false),
            arguments(10, false)
        );
    }
}