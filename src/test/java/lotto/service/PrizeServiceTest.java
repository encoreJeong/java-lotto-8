package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.model.Budget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeServiceTest {

    @DisplayName("총 상금 계산")
    @Test
    void calculateTotalPrize() {
        //given
        Budget budget = Budget.of(6_000);
        List<WinningRank> result = List.of(WinningRank.FIRST, WinningRank.SECOND,  WinningRank.THIRD, WinningRank.FOURTH, WinningRank.FIFTH, WinningRank.NONE);
        long actualTotalPrize = 2_031_555_000;

        PrizeService service = new PrizeService(result, budget);

        //when
        long totalPrize = service.calculateTotalPrize();

        //then
        assertEquals(actualTotalPrize,  totalPrize);
    }

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