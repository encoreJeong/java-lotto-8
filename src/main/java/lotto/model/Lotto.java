package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateEachUnique(numbers);
        validateBetween(1, 45, numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_COUNT_INVALID.getMessage());
        }
    }

    private void validateEachUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateBetween(int min, int max, List<Integer> numbers) {
        boolean invalid = numbers.stream()
                                .anyMatch(n -> n < min || n > max);

        if (invalid) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_A_LOTTO.getMessage());
        }
    }

    public boolean contains(final Bonus bonus) {
        return numbers.contains(bonus.getNumber());
    }

}
