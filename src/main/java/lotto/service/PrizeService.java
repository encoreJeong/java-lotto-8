package lotto.service;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.model.Budget;

public class PrizeService {

    private final List<WinningRank> result;
    private final Budget budget;

    public PrizeService(List<WinningRank> result, Budget budget) {
        this.result = result;
        this.budget = budget;
    }

    public float calculateROI() {
        double roi = (double) calculateTotalPrize() / budget.getInt();
        return Math.round(roi * 10) / 10f;
    }

    private long calculateTotalPrize() {
        return result.stream().mapToLong(WinningRank::getPrize).sum();
    }
}
