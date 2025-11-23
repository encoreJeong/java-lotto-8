package app.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.app.model.Lotto;
import lotto.app.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("생성 성공")
    @Test
    void of() {
        //given
        List<Lotto> values = List.of(
                                new Lotto(List.of(1,2,3,4,5,6)),
                                new Lotto(List.of(45,43,42,41,40,39)));

        //when
        Lottos lottos = Lottos.of(values);

        //then
        assertEquals(values.size(), lottos.size());
    }

    @DisplayName("비어있는 로또 리스트 생성 성공")
    @Test
    void none() {
        //when
        Lottos lottos = Lottos.none();

        //then
        assertEquals(0, lottos.size());
    }

    @DisplayName("로또 추가 성공")
    @Test
    void add() {
        //given
        Lottos lottos = Lottos.none();
        Lotto lotto = new  Lotto(List.of(1,2,3,4,5,6));

        //when
        lottos.add(lotto);

        //then
        assertEquals(1, lottos.size());
    }
}