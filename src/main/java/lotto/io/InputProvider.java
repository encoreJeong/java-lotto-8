package lotto.io;

import java.util.List;

public interface InputProvider {
    Integer readInteger();
    List<Integer> readIntegers();
    String readConsoleLine();
}
