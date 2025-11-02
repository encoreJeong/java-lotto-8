package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.message.ExceptionMessage;
import lotto.util.Parser;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public Integer readInteger() {
        String line = readConsoleLine();
        return Parser.parseInt(line);
    }

    @Override
    public List<Integer> readIntegers() {
        String line = readConsoleLine();
        return Parser.parseInts(line);
    }

    @Override
    public String readConsoleLine() {
        return Console.readLine();
    }
}
