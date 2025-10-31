package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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

    @DisplayName("Integer 여러개 파싱 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,1,1,1,1,1", "6,5,4,3,2,1", "10,20,30,40,50,60", "100,2,30,4000,5,666"})
    void parseInts(String source) {
        //when
        List<Integer> Ints =  Parser.parseInts(source);

        //then
        assertEquals(6, Ints.size());
    }

    @DisplayName("Integer 여러개 파싱 실패")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3,4,5,6", "1,2,", "10,a,30,40,50,60", ",", "a,b,c"})
    void parseInts_should_fail(String source) {
        //when
        Executable executable = () -> Parser.parseInts(source);

        //then
        assertThrows(IllegalArgumentException.class, executable);
    }

}