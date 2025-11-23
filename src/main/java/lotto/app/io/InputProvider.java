package lotto.app.io;

import java.util.List;

public interface InputProvider {

    Integer readInteger(String value);
    List<Integer> readIntegers(String values);
}
