package lotto.app.service;

import java.util.List;
import lotto.app.enums.WinningRank;
import lotto.app.model.Budget;

@FunctionalInterface
public interface PrizeServiceFactory {
    PrizeService create(List<WinningRank> result, Budget budget);
}
