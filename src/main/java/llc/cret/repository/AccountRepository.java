package llc.cret.repository;

import llc.cret.repository.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 口座リポジトリ.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

    List<Account> findByBranchAndAccountAndStatusNot(String branch, String account, String status);
}
