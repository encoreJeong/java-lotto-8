package lotto.app.enums;

import java.util.Arrays;
import java.util.List;
import lotto.app.dto.MatchResultDTO;
import lotto.app.io.MessageFormatter;

public enum WinningRank {

    FIFTH(3, BonusMatchedStatus.ANY, 5_000),
    FOURTH(4, BonusMatchedStatus.ANY, 50_000),
    THIRD(5, BonusMatchedStatus.FALSE,1_500_000),
    SECOND(5, BonusMatchedStatus.TRUE,30_000_000),
    FIRST(6, BonusMatchedStatus.ANY, 2_000_000_000),
    NONE(0, BonusMatchedStatus.ANY, 0);

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

    public int getPrize() {
        return prize;
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

        public String toString() {
            if(this == TRUE) {
                return ", 보너스 볼 일치 ";
            }
            return " ";
        }
    }

    @Override
    public String toString() {

        if(this == NONE) {
            return "";
        }

        StringBuilder message = new StringBuilder();
        message.append(matchedNumberCount).append("개 일치")
                .append(isBonusMatch.toString())
                .append(MessageFormatter.formatPrize(prize));

        return message.toString();
    }

    public static List<WinningRank> allValues() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }
}
