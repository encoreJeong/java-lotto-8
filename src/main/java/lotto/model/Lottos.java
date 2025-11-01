package lotto.model;

import java.util.ArrayList;
import java.util.List;

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

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int size() {
        return lottos.size();
    }
}
