package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class WinningConditionTest {

    @DisplayName("유효한 우승 조건")
    @Test
    void of() {
        //given
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        Bonus number = Bonus.of(7);

        //when
        WinningCondition winningCondition = WinningCondition.of(winningNumbers, number);

        //then
        assertNotNull(winningCondition);
    }

    @DisplayName("중복된 보너스 번호")
    @Test
    void of_should_fail() {
        //given
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        Bonus number = Bonus.of(6);

        //when
        Executable executable = () -> WinningCondition.of(winningNumbers, number);

        //then
        assertThrows(IllegalArgumentException.class, executable);
    }
}