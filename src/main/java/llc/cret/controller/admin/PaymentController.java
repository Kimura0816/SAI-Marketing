package llc.cret.controller.admin;

import llc.cret.controller.dto.PaymentHistoryDto;
import llc.cret.controller.dto.PaymentHistoryQueryRequestDto;
import llc.cret.controller.dto.PaymentHistoryQueryResponseDto;
import llc.cret.repository.entity.PaymentHistory;
import llc.cret.service.PaymentHistoryQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 入金 Restコントローラ.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentHistoryQueryService paymentHistoryQueryService;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 入金履歴検索.
     * @param body 入金履歴検索条件
     * @return 入金履歴情報.
     */
    @RequestMapping(value = "/rest/payment-history/query", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<PaymentHistoryQueryResponseDto> doFind(@RequestBody PaymentHistoryQueryRequestDto body) {
        List<PaymentHistory> result = paymentHistoryQueryService.find(body);
        ArrayList<PaymentHistoryDto> resultDto = new ArrayList<>();
        for (PaymentHistory histry : result) {
            resultDto.add(toDto(histry));
        }
        PaymentHistoryQueryResponseDto res = PaymentHistoryQueryResponseDto.builder().result(resultDto).build();

        return ResponseEntity.ok(res);
    }

    /**
     * 入金履歴検索結果 作成.
     * @param entity 入金履歴検
     * @return 入金履歴検DTO
     */
    private PaymentHistoryDto toDto(PaymentHistory entity) {

        return PaymentHistoryDto.builder()
                    .historyNo(entity.getHistoryNo())
                    .depositDate(entity.getDepositDate().format(formatter))
                    .branch(entity.getBranch())
                    .account(entity.getAccount())
                    .transferSource(entity.getTransferSource())
                    .withdrawalAmount(entity.getWithdrawalAmount().toString())
                    .depositAmount(entity.getDepositAmount().toString())
                    .balance(entity.getBalance().toString())
                    .memo(entity.getMemo())
                    .build();
    }
}
