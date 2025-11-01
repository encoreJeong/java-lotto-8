package lotto.enums;

import java.util.Arrays;
import lotto.dto.MatchResultDTO;

public enum WinningRank {

    NONE(0, BonusMatchedStatus.ANY, 0),
    FIRST(6, BonusMatchedStatus.ANY, 2_000_000_000),
    SECOND(5, BonusMatchedStatus.TRUE,30_000_000),
    THIRD(5, BonusMatchedStatus.ANY,1_500_000),
    FOURTH(4, BonusMatchedStatus.ANY, 50_000),
    FIFTH(3, BonusMatchedStatus.ANY, 5_000);

    private final int matchedNumberCount;
    private final BonusMatchedStatus isBonusMatch;
    private final int prize;

    WinningRank(int matchedNumberCount, BonusMatchedStatus isBonusMatchedStatusMatch, int prize) {
        this.matchedNumberCount = matchedNumberCount;
        this.isBonusMatch = isBonusMatchedStatusMatch;
        this.prize = prize;
    }

    public static WinningRank rankOf(MatchResultDTO result) {

        return Arrays.stream(values())
                        .filter(rank -> isMatched(result, rank))
                        .findFirst()
                        .orElse(NONE);
    }

    private static boolean isMatched(MatchResultDTO result, WinningRank rank) {
        return rank.matchedNumberCount == result.matchedNumberCount()
                && rank.isBonusMatch.matches(result.isBonsMatched());
    }

    private enum BonusMatchedStatus {
        ANY, TRUE, FALSE;
        boolean matches(boolean b) {
            return switch (this) {
                case ANY  -> true;
                case TRUE -> b;
                case FALSE-> !b;
            };
        }
    }

}
