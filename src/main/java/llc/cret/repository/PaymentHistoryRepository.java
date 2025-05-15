package llc.cret.repository;

import llc.cret.repository.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 入金履歴 リポジトリ.
 */
@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Integer> , JpaSpecificationExecutor<PaymentHistory> {

}
