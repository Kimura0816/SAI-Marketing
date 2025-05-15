package llc.cret.repository.specication;

import jakarta.persistence.criteria.Predicate;
import llc.cret.controller.dto.PaymentHistoryQueryRequestDto;
import llc.cret.repository.entity.PaymentHistory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentHistorySpeciification {

    public Specification<PaymentHistory> createConditions(PaymentHistoryQueryRequestDto dto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            // 入金日(From)
            if (StringUtils.isNotEmpty(dto.getFrom())) {
                LocalDate date = LocalDate.parse(dto.getFrom().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                predicates.add(cb.greaterThanOrEqualTo(root.get("depositDate"), date));
            }
            // 入金日(To)
            if (StringUtils.isNotEmpty(dto.getTo())) {
                LocalDate date = LocalDate.parse(dto.getTo().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                predicates.add(cb.lessThanOrEqualTo(root.get("depositDate"), date));
            }
            // 支店CD
            if (StringUtils.isNotEmpty(dto.getBranch())) {
                predicates.add(cb.equal(root.get("branch"), dto.getBranch().trim()));
            }
            // 口座番号
            if (StringUtils.isNotEmpty(dto.getAccount())) {
                predicates.add(cb.equal(root.get("account"), dto.getAccount().trim()));
            }
            // 振込元
            if (StringUtils.isNotEmpty(dto.getTransferSource())) {
                predicates.add(cb.like(root.get("transferSource"), "%" + dto.getTransferSource().trim() + "%"));
            }

            query.orderBy(cb.desc(root.get("historyNo").as(Integer.class)));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
