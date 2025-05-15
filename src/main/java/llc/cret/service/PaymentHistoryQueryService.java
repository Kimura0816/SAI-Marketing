package llc.cret.service;

import jakarta.transaction.Transactional;
import llc.cret.controller.dto.PaymentHistoryQueryRequestDto;
import llc.cret.repository.PaymentHistoryRepository;
import llc.cret.repository.entity.PaymentHistory;
import llc.cret.repository.specication.PaymentHistorySpeciification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入金サービス.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PaymentHistoryQueryService {
    private final PaymentHistorySpeciification paymentHistorySpeciification;
    private final PaymentHistoryRepository paymentHistoryRepository;

    /**
     * 入金履歴検索.
     * @param dto 検索条件
     * @return 検索結果
     */
    public List<PaymentHistory> find(PaymentHistoryQueryRequestDto dto) {
        return paymentHistoryRepository.findAll(paymentHistorySpeciification.createConditions(dto));
    }
}
