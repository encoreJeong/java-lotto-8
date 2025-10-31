package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import lotto.message.ExceptionMessage;
import lotto.util.Parser;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public String readString() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY.getMessage());
        }
    }

    @Override
    public Integer readInteger() {
        try {
            String line = Console.readLine();
            return Parser.parseInt(line);

        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY.getMessage());
        }
    }
}
