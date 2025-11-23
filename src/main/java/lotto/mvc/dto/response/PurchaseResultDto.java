package lotto.mvc.dto.response;

import java.util.List;

public record PurchaseResultDto(List<String> issuedLottos, int lottoQuantity, String message) {
}
