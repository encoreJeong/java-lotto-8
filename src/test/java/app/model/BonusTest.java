package app.model;

import static org.junit.jupiter.api.Assertions.*;

import lotto.app.model.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {

    @DisplayName("유효한 보너스 번호")
    @ParameterizedTest
    @ValueSource(ints =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 45})
    void of(int value) {
        //when
        Bonus number = Bonus.of(value);

        //then
        assertEquals(value, number.getNumber());
    }

    @DisplayName("유효하지 않은 보너스 번호")
    @ParameterizedTest
    @ValueSource(ints =  {0, 46, -1})
    void of_should_fail(int value) {
        //when
        Executable executable = () -> Bonus.of(value);

        //then
        assertThrows(IllegalArgumentException.class, executable);
    }

}