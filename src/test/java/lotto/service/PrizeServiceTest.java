package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.model.Budget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeServiceTest {

    @DisplayName("수익률 계산")
    @Test
    void calculateROI() {
        //given
        Budget budget = Budget.of(6_000);
        List<WinningRank> result = List.of(WinningRank.FIRST, WinningRank.SECOND,  WinningRank.THIRD, WinningRank.FOURTH, WinningRank.FIFTH, WinningRank.NONE);

        float actualROI = 338592.5f;

        PrizeService service = new PrizeService(result, budget);

        //when
        float roi = service.calculateROI();

        //then
        assertEquals(actualROI, roi);
    }
}