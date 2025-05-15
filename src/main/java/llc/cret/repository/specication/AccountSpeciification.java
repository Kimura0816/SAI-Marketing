package llc.cret.repository.specication;

import jakarta.persistence.criteria.Predicate;
import llc.cret.repository.entity.Account;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

/**
 * 口座検索条件.
 */
@Component
public class AccountSpeciification {

    public Specification<Account> createConditions(Account conditions) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            // 支店CD
            if (StringUtils.isNotEmpty(conditions.getBranch())) {
                predicates.add(cb.equal(root.get("branch"), conditions.getBranch().trim()));
            }
            // 口座番号
            if (StringUtils.isNotEmpty(conditions.getAccount())) {
                predicates.add(cb.equal(root.get("account"), conditions.getAccount().trim()));
            }
            // 支店名
            if (StringUtils.isNotEmpty(conditions.getBranchNm())) {
                predicates.add(cb.equal(root.get("branchnm"), conditions.getBranchNm()));
            }
            // 口座名義
            if (StringUtils.isNotEmpty(conditions.getAccountNm())) {
                predicates.add(cb.equal(root.get("accountNm"), conditions.getAccountNm()));
            }
            // 開設日
            if (nonNull(conditions.getOpenDate())) {
                predicates.add(cb.equal(root.get("openDate"), conditions.getOpenDate()));
            }
            // ステータス
            if (StringUtils.isNotEmpty(conditions.getStatus())) {
                predicates.add(cb.equal(root.get("status"), conditions.getStatus()));
            }
            // メモ
            if (StringUtils.isNotEmpty(conditions.getMemo())) {
                predicates.add(cb.like(root.get("memo"), "%" + conditions.getMemo().trim() + "%"));
            }

            query.orderBy(cb.asc(root.get("account").as(String.class)));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
