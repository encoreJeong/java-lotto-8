package lotto.service;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.model.Budget;

@FunctionalInterface
public interface PrizeServiceFactory {
    PrizeService create(List<WinningRank> result, Budget budget);
}
