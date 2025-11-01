package lotto.model;

import java.util.List;
import lotto.dto.MatchResultDTO;
import lotto.enums.WinningRank;

public class LottoMatcher {

    private final Lottos lottos;
    private final WinningCondition winningCondition;

    private LottoMatcher(Lottos lottos, WinningCondition winningCondition) {
        this.lottos = lottos;
        this.winningCondition = winningCondition;
    }

    public static LottoMatcher of(Lottos lottos,  WinningCondition winningCondition) {
        return new LottoMatcher(lottos, winningCondition);
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
