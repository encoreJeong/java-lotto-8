package lotto.message;

public enum ExceptionMessage {

    EMPTY("[ERROR] 입력은 NULL이거나 빈 문자열일 수 없습니다.\n"),
    BUDGET_INSUFFICIENT("[ERROR] 예산이 부족합니다.\n"),
    REMAINDER_EXIST("[ERROR] 예산의 최소 단위는 1000 입니다.\n"),
    NOT_INTEGER("[ERROR] 정수가 아닙니다.\n");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
