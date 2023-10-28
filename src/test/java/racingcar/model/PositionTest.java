package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class PositionTest {

    @CsvSource({"4, 1", "7, 1", "9, 1"})
    @ParameterizedTest
    void 매개변수로_들어온_값이_4이상이면_위치가_변한다(int number, int expected) {
        // given
        Position position = new Position(0);

        // when
        position.move(number);

        // then
        assertThat(position.getPosition()).isEqualTo(expected);
    }

    @CsvSource({"2, 0", "1, 0"})
    @ParameterizedTest
    void 매개변수로_들어온_값이_4미만이면_위치가_그대로이다(int number, int expected) {
        // given
        Position position = new Position(0);

        // when
        position.move(number);

        // then
        assertThat(position.getPosition()).isEqualTo(expected);
    }

    @Test
    void 이름이_같으면_같은_값으로_판단한다() {
        // given
        Position result = new Position(0);
        Position expected = new Position(0);

        // when & then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 위치를_반환한다() {
        // given
        int input = 4;
        Position result = new Position(input);

        // when & then
        assertThat(result.getPosition()).isEqualTo(input);
    }
}
