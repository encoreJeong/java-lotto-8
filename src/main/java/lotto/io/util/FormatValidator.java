package lotto.io.util;

import java.util.regex.Pattern;
import lotto.message.ExceptionMessage;

public class FormatValidator {

    private static final Pattern INT = Pattern.compile("[-+]?\\d+");

    //하나 이상의 정수들이 콤마로만 구분되어 있으며, 다른 문자가 없어야 한다
    private static final Pattern INTEGERS = Pattern.compile("^[0-9]+(,[0-9]+)*$");

    public static void validateInteger(String input) {
        if (input == null || !INT.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER.getMessage());
        }
    }

    public static void validateIntegers(String input) {
        if (input == null || !INTEGERS.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGERS.getMessage());
        }
    }
}