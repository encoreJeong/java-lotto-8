package lotto.util;

import lotto.message.ExceptionMessage;

public class Parser {
    public static Integer parseInt(final String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER.getMessage());
        }
    }
}
