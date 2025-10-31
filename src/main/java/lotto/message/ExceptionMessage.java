package lotto.message;

public enum ExceptionMessage {

    EMPTY("[ERROR] 입력은 NULL이거나 빈 문자열일 수 없습니다.\n"),
    BUDGET_INSUFFICIENT("[ERROR] 예산이 부족합니다.\n"),
    REMAINDER_EXIST("[ERROR] 예산의 최소 단위는 1000 입니다.\n"),
    NOT_INTEGER("[ERROR] 정수가 아닙니다.\n"),
    NOT_INTEGERS("[ERROR] 여러 정수 입력 형식이 아닙니다.\n"),
    NOT_A_BONUS("[ERROR] 보너스 번호 형식이 잘못 됐습니다.\n"),
    DUPLICATED_BONUS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.\n"),
    NUMBER_COUNT_INVALID("[ERROR] 로또 번호는 6개여야 합니다.\n"),
    DUPLICATED_NUMBER("[ERROR] 로또 번호는 서로 중복 될 수 없습니다.\n"),
    NOT_A_LOTTO("[ERROR] 로또 번호는 1부터 45 사이의 정수입니다.\n");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
