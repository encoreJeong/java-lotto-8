package lotto.io;

public class ConsoleOutputProvider implements OutputProvider {
    @Override
    public void show(String message) {
        System.out.print(message);
    }
}
