package llc.cret.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * システム設定.
 */
@Entity
@Table(name = "system_config")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SystemConfig {

    /** キー */
    @Id
    @Column(name = "keyword")
    private String keyword;

    /** 値 */
    @Column(name = "val")
    private String val;

    /** 作成日 */
    @CreatedDate
    @Column(name = "created_at", updatable = true)
    private LocalDateTime createdAt;

    /** 更新日 */
    @LastModifiedDate
    @Column(name = "updated_at")
    public LocalDateTime gupdatedAt;

}
