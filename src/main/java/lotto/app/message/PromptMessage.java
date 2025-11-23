package lotto.app.message;

public enum PromptMessage {

    BUDGET("구입금액을 입력해 주세요.\n"),
    LOTTO("\n당첨 번호를 입력해 주세요.\n"),
    BONUS("\n보너스 번호를 입력해 주세요.\n"),
    QUANTITY("\n%d개를 구매했습니다.\n"),
    STATISTIC("\n당첨 통계\n---\n");

    private final String message;

    PromptMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
