package lotto.enums;

public enum LottoRule {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000),
    MIN_PURCHASE_QUANTITY(1);

    public final int value;

    LottoRule(int value) {
        this.value = value;
    }
}
