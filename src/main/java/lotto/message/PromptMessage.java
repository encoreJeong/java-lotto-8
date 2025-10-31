package lotto.message;

public enum PromptMessage {

    BUDGET("구입금액을 입력해 주세요.\n"),
    LOTTO("당첨 번호를 입력해 주세요.\n"),
    BONUS("보너스 번호를 입력해 주세요.\n");

    private final String message;

    PromptMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
