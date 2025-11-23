package lotto.mvc.dto;

import com.encorejeong.encoreframework.web.request.vo.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import lotto.mvc.dto.request.BudgetDto;
import lotto.mvc.dto.request.WinningConditionDto;
import lotto.mvc.dto.response.PurchaseResultDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.app.enums.WinningRank;
import lotto.app.io.MessageFormatter;
import lotto.app.model.Lottos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mapper {

    private static final Logger logger  = LoggerFactory.getLogger(Mapper.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static BudgetDto toBudgetDto(RequestBody requestBody) {
        Map<String, Object> body = requestBody.getBody();
        return objectMapper.convertValue(body, BudgetDto.class);
    }

    public static PurchaseResultDto toPurchaseResultDto(Lottos issuedLottos, int lottoQuantity) {
        Map<String, Object> map = new HashMap<>();

        List<String> lottoStrings = issuedLottos.stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))
                ).toList();

        map.put("issuedLottos", lottoStrings);
        map.put("lottoQuantity", lottoQuantity);
        map.put("message", String.join("\n", MessageFormatter.formatQuantity(lottoQuantity), MessageFormatter.formatLottos(issuedLottos)));

        return objectMapper.convertValue(map, PurchaseResultDto.class);
    }

    public static WinningConditionDto toWinningConditionDto(RequestBody requestBody) {
        Map<String, Object> body = requestBody.getBody();
        return objectMapper.convertValue(body, WinningConditionDto.class);
    }

    public static String toMatchingResultDto(List<WinningRank> result, double roi) {
        return MessageFormatter.formatResult(result, roi);
    }

}
