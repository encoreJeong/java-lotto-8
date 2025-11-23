package lotto.app.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.app.enums.LottoRule;
import lotto.app.message.ExceptionMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sort();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateEachUnique(numbers);
        validateBetweenLottoMinMax(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.LOTTO_SIZE.value) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_COUNT_INVALID.getMessage());
        }
    }

    private void validateEachUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateBetweenLottoMinMax(List<Integer> numbers) {
        boolean invalid = numbers.stream()
                                .anyMatch(n -> n < LottoRule.MIN_NUMBER.value || n > LottoRule.MAX_NUMBER.value);

        if (invalid) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_A_LOTTO.getMessage());
        }
    }

    public static Lotto issue() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoRule.MIN_NUMBER.value, LottoRule.MAX_NUMBER.value, LottoRule.LOTTO_SIZE.value));
    }

    public boolean contains(final Bonus bonus) {
        return numbers.contains(bonus.getNumber());
    }

    public int countMatched(Lotto other) {
        Set<Integer> others = new HashSet<>(other.numbers);
        return Math.toIntExact(this.numbers.stream().filter(others::contains).count());
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
