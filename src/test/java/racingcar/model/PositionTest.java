package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

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
    void 주어진_값이_4이상일_때_위치가_이동한다(int number, int expected) {
        // given
        Position position = Position.createDefault();

        // when
        position.move(number);

        // then
        assertThat(position.getPosition()).isEqualTo(expected);
    }

    @CsvSource({"2, 0", "1, 0"})
    @ParameterizedTest
    void 매개변수로_들어온_값이_4미만이면_위치가_그대로이다(int number, int expected) {
        // given
        Position position = Position.createDefault();

        // when
        position.move(number);

        // then
        assertThat(position.getPosition()).isEqualTo(expected);
    }

    @Test
    void 동일한_위치를_가진_Position_인스턴스는_동등하다() {
        // given
        Position result = Position.createDefault();
        Position expected = Position.createDefault();

        // when & then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 현재_위치를_반환한다() {
        // given
        int expected = 1;
        Position position = Position.createDefault();
        position.move(4);

        // when
        int result = position.getPosition();

        // when & then
        assertThat(result).isEqualTo(expected);
    }
}
