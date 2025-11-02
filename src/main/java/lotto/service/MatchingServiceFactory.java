package lotto.service;

import lotto.model.Lottos;
import lotto.model.WinningCondition;

@FunctionalInterface
public interface MatchingServiceFactory {
    MatchingService create(Lottos lottos, WinningCondition winningCondition);
}
