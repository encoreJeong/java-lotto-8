package lotto.app.util;

import java.util.Arrays;
import java.util.List;
import lotto.app.io.util.FormatValidator;
import lotto.app.message.ExceptionMessage;

public class Parser {

    private static final String SPLIT_DELIMITER = ",";

    public static Integer parseInt(final String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER.getMessage());
        }
    }

    public static List<Integer> parseInts(String line) {
        FormatValidator.validateIntegers(line);
        return Arrays.stream(line.split(SPLIT_DELIMITER)).map(Parser::parseInt).toList();
    }
}
