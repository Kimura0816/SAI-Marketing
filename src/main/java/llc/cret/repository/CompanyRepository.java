package llc.cret.repository;

import llc.cret.repository.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 会社リポジトリ.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, String>, JpaSpecificationExecutor<Company> {

    /**
     * 会社CD生成用シーケンス取得.
     * @return シーケンス.
     */
    @Query(value="SELECT nextval('company_seq')", nativeQuery = true)
    Integer getSequence();

    /**
     * サインイン.
     * @param id 会社ID
     * @param pass
     * @return
     */
     Optional<Company> findByCompanyCdAndPassword(String id, String pass);
}
