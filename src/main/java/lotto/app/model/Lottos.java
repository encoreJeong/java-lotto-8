package lotto.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos none() {
        return new Lottos(List.of());
    }

    public static Lottos issueLottoForNTimes(int lottoQuantity) {
        return Lottos.of(
                    IntStream.range(0, lottoQuantity)
                        .mapToObj(i -> Lotto.issue())
                        .toList()
                );
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int size() {
        return lottos.size();
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }
}
