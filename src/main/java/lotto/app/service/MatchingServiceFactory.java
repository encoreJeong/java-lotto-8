package lotto.app.service;

import lotto.app.model.Lottos;
import lotto.app.model.WinningCondition;

@FunctionalInterface
public interface MatchingServiceFactory {
    MatchingService create(Lottos lottos, WinningCondition winningCondition);
}
