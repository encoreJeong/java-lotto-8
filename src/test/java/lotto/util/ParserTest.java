package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @DisplayName("Integer 파싱 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "0", "-1", "-999", "10000000"})
    void parseInt(String source) {
        assertEquals(Integer.valueOf(source), Parser.parseInt(source));
    }

    @DisplayName("Integer 파싱 실패")
    @ParameterizedTest
    @ValueSource(strings = {"banana", "120-32", "", " ", " 1", "\n"})
    void parseInt_should_fail(String source) {
        //when
        Executable executable = () -> Parser.parseInt(source);

        //then
        assertThrows(IllegalArgumentException.class, executable);
    }
}