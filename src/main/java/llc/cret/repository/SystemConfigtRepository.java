package llc.cret.repository;

import llc.cret.repository.entity.SystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * システム定義.
 */
@Repository
public interface SystemConfigtRepository extends JpaRepository<SystemConfig, String> {

    /**
     * マップ形式での取得.
     * @return システム定義マップ
     */
    default Map<String,String> getMap() {
        return findAll().stream().collect(
                Collectors.toMap(SystemConfig::getKeyword, SystemConfig::getVal));
    }
}
