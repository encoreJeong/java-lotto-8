package lotto.app.service;

import java.util.List;
import lotto.app.dto.MatchResultDTO;
import lotto.app.enums.WinningRank;
import lotto.app.model.Lottos;
import lotto.app.model.WinningCondition;

public class MatchingService {

    private final Lottos lottos;
    private final WinningCondition winningCondition;

    public MatchingService(Lottos lottos, WinningCondition winningCondition) {
        this.lottos = lottos;
        this.winningCondition = winningCondition;
    }

    public List<WinningRank> getMatchResults() {

        return lottos.stream()
                .map(lotto ->
                        new MatchResultDTO(
                            lotto.countMatched(winningCondition.getWinningNumbers()),
                            lotto.contains(winningCondition.getBonus())
                        )
                )
                .map(WinningRank::rankOf)
                .toList();
    }
}
