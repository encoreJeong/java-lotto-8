package lotto.message;

import lotto.enums.LottoRule;

public enum ExceptionMessage {

    EMPTY("입력은 NULL이거나 빈 문자열일 수 없습니다."),
    BUDGET_INSUFFICIENT("예산이 부족합니다."),
    REMAINDER_EXIST("예산의 최소 단위는 %d 입니다.".formatted(LottoRule.LOTTO_PRICE.value)),
    NOT_INTEGER("정수가 아닙니다."),
    NOT_INTEGERS("여러 정수 입력 형식이 아닙니다."),
    NOT_A_BONUS("보너스 번호 형식이 잘못 됐습니다."),
    DUPLICATED_BONUS("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    NUMBER_COUNT_INVALID("로또 번호는 %d개여야 합니다.".formatted(LottoRule.LOTTO_SIZE.value)),
    DUPLICATED_NUMBER("로또 번호는 서로 중복 될 수 없습니다."),
    NOT_A_LOTTO("로또 번호는 %d부터 %d 사이의 정수입니다.".formatted(LottoRule.MIN_NUMBER.value, LottoRule.MAX_NUMBER.value));

    private final static String PREFIX = "[ERROR] ";
    private final static String SUFFIX = "\n";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message + SUFFIX;
    }
}
