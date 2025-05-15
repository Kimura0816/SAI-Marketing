package llc.cret.repository.specication;

import jakarta.persistence.criteria.Predicate;
import llc.cret.repository.entity.Company;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanySpeciification {

    public Specification<Company> createConditions(Company conditions) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            // 会社CD
            if (StringUtils.isNotEmpty(conditions.getCompanyCd())) {
                predicates.add(cb.equal(root.get("companyCd"), conditions.getCompanyCd().trim()));
            }
            // 会社名
            if (StringUtils.isNotEmpty(conditions.getCompanyName())) {
                predicates.add(cb.like(root.get("companyName"), "%" + conditions.getCompanyName().trim() + "%"));
            }
            // 権限
            if (StringUtils.isNotEmpty(conditions.getAuth())) {
                predicates.add(cb.equal(root.get("auth"), conditions.getAuth()));
            }
            // 企業URL
            if (StringUtils.isNotEmpty(conditions.getCompanyUrl())) {
                predicates.add(cb.like(root.get("companyUrl"), "%" + conditions.getCompanyUrl().trim() + "%"));
            }
            // 特商URL
            if (StringUtils.isNotEmpty(conditions.getSpecialSalesUrl())) {
                predicates.add(cb.like(root.get("specialSalesUrl"), "%" + conditions.getSpecialSalesUrl().trim() + "%"));
            }
            // ラポリURL
            if (StringUtils.isNotEmpty(conditions.getPuraporiUrl())) {
                predicates.add(cb.like(root.get("puraporiUrl"), "%" + conditions.getPuraporiUrl().trim() + "%"));
            }
            // 連絡先メールアドレス
            if (StringUtils.isNotEmpty(conditions.getEmail())) {
                predicates.add(cb.equal(root.get("email"), conditions.getEmail().trim()));
            }
            // 連絡先電話番号
            if (StringUtils.isNotEmpty(conditions.getTel())) {
                predicates.add(cb.equal(root.get("tel"), conditions.getTel().trim()));
            }

            query.orderBy(cb.asc(root.get("companyName").as(String.class)));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
