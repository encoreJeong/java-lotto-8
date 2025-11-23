package lotto.mvc.dto.request;

import java.util.List;

public record WinningConditionDto(List<String> issuedLottos, String winningNumbers, String bonus, String budget) {
}
