package io.github.vlad324.n449;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.vlad324.n449.Codec.TreeNode;
import org.junit.jupiter.api.Test;

class CodecTest {

    @Test
    void should_serialize_and_deserialize_BST() {
        // given
        final var serializer = new Codec();
        final var deserializer = new Codec();

        final var expected = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        // when
        final var string = serializer.serialize(expected);
        final var actual = deserializer.deserialize(string);

        // then
        assertThat(string).isEqualTo("2 1 3 null null null null");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_serialize_and_deserialize_null() {
        // given
        final var serializer = new Codec();
        final var deserializer = new Codec();

        // when
        final var string = serializer.serialize(null);
        final var actual = deserializer.deserialize(string);

        // then
        assertThat(string).isEqualTo("null");
        assertThat(actual).isEqualTo(null);
    }
}