package lotto.io;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.message.PromptMessage;
import lotto.model.Lottos;

public class MessageFormatter {

    public static String formatQuantity(int quantity) {
        return PromptMessage.QUANTITY.getMessage().formatted(quantity);
    }

    public static String formatLottos(Lottos lottos) {
        StringBuilder message = new StringBuilder();

        lottos.stream().forEach(lotto -> message.append(lotto.toString()).append("\n"));

        return message.toString();
    }

    public static String formatResult(List<WinningRank> result, float roi) {
        StringBuilder message = new StringBuilder();

        message.append(PromptMessage.STATISTIC.getMessage());
        message.append(formatMatchResult(result));
        message.append(formatROI(roi));

        return message.toString();
    }

    private static String formatMatchResult(List<WinningRank> result) {
        StringBuilder message = new StringBuilder();
        WinningRank.allValues().forEach(rank -> {
            int rankCount = Math.toIntExact(result.stream().filter(resultRank -> rank == resultRank).count());
            message.append(rank.toString())
                    .append(" - ")
                    .append(rankCount).append("개\n");
        });
        return message.toString();
    }

    private static String formatROI(float roi) {
        return "총 수익률은 %.1f%%입니다.".formatted(roi);
    }

    public static String formatPrize(int prize) {
        return String.format("(%,d원)", prize);
    }
}
