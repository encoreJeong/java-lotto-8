package lotto.app.io;

import java.util.List;
import lotto.app.util.Parser;

public class ProgrammaticInputProvider implements InputProvider {

    @Override
    public Integer readInteger(String value) {
        return Parser.parseInt(value);
    }

    @Override
    public List<Integer> readIntegers(String values) {
        return Parser.parseInts(values);
    }
}
