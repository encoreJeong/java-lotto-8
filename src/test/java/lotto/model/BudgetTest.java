package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BudgetTest {

    @DisplayName("유효한 로또 구입 금액")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 100000, 1000000, 1235000})
    void of(int value) {
        //when
        Budget budget = Budget.of(value);

        //then
        assertEquals(value, budget.getInt());
    }

    @DisplayName("무효한 로또 구입 금액")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -1, 0, 999, 1001, 20100, Integer.MAX_VALUE})
    void of_should_fail(int value) {
        //when
        Executable executable = () -> Budget.of(value);

        //then
        assertThrows(IllegalArgumentException.class, executable);
    }
}