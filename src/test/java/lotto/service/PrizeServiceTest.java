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
        Budget budget = Budget.of(2_000);
        List<WinningRank> result = List.of(WinningRank.FOURTH, WinningRank.FIFTH);

        float actualROI = 2750.0f;

        PrizeService service = new PrizeService(result, budget);

        //when
        float roi = service.calculateROI();

        //then
        assertEquals(actualROI, roi);
    }
}