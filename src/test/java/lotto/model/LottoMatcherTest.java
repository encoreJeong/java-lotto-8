package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.enums.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {

    @DisplayName("매칭 성공")
    @Test
    void getMatchResults() {
        //given
        Lotto allMatched = new Lotto(List.of(5,6,7,8,9,10));
        Lotto fiveAndBonusMatched = new Lotto(List.of(5,6,7,8,9,17));
        Lotto fiveMatched = new Lotto(List.of(5,6,7,8,9,45));
        Lotto fourMatched = new Lotto(List.of(3,4,5,6,7,8));
        Lotto threeMatched = new Lotto(List.of(2,3,4,5,6,7));
        Lotto twoMatched = new Lotto(List.of(9,10,11,12,13,14));
        Lotto oneMatched = new Lotto(List.of(10,11,12,13,14,15));
        Lotto onlyBonusMatched = new Lotto(List.of(17,41,42,43,44,45));
        Lotto nothingMatched = new Lotto(List.of(40,41,42,43,44,45));

        Lottos issuedLottos = Lottos.of(List.of(allMatched, fiveAndBonusMatched, fiveMatched, fourMatched, threeMatched, twoMatched, oneMatched, onlyBonusMatched, nothingMatched));

        Lotto winningNumbers = new Lotto(List.of(5,6,7,8,9,10));
        Bonus bonus = Bonus.of(17);

        WinningCondition winningCondition = WinningCondition.of(winningNumbers, bonus);

        //when
        LottoMatcher matcher = LottoMatcher.of(issuedLottos, winningCondition);
        List<WinningRank> results = matcher.getMatchResults();

        //then
        assertEquals(1, results.stream().filter(rank -> rank == WinningRank.FIRST).count());
        assertEquals(1, results.stream().filter(rank -> rank == WinningRank.SECOND).count());
        assertEquals(1, results.stream().filter(rank -> rank == WinningRank.THIRD).count());
        assertEquals(1, results.stream().filter(rank -> rank == WinningRank.FOURTH).count());
        assertEquals(1, results.stream().filter(rank -> rank == WinningRank.FIFTH).count());
        assertEquals(4, results.stream().filter(rank -> rank == WinningRank.NONE).count());
    }
}