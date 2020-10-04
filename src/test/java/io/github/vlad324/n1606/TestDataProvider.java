package io.github.vlad324.n1606;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestDataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        final var lines = Files.readAllLines(Path.of(TestDataProvider.class.getResource("/data/test_data.txt").toURI()));
        int k = Integer.parseInt(lines.get(0));

        int[] arrival = Arrays.stream(lines.get(1).split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] load = Arrays.stream(lines.get(2).split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        return Stream.of(
            arguments(k, arrival, load, List.of(2529, 3563))
        );
    }
}
