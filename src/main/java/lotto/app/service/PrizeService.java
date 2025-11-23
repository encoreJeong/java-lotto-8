package lotto.app.service;

import java.util.List;
import lotto.app.enums.WinningRank;
import lotto.app.model.Budget;

public class PrizeService {

    private final List<WinningRank> result;
    private final Budget budget;

    public PrizeService(List<WinningRank> result, Budget budget) {
        this.result = result;
        this.budget = budget;
    }

    public float calculateROI() {
        double roi = ((double) calculateTotalPrize() / budget.getInt()) * 100;
        return Math.round(roi * 100) / 100f;
    }

    private long calculateTotalPrize() {
        return result.stream().mapToLong(WinningRank::getPrize).sum();
    }
}
