package llc.cret.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 口座.
 */
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
public class Account {

    /** 口座シーケンス */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_seq")
    private Integer accountSeq;

    /** 支店CD */
    @Column(name = "branch")
    private String branch;

    /** 口座番号 */
    @Column(name = "account")
    private String account;

    /** 支店名 */
    @Column(name = "branch_nm")
    private String branchNm;

    /** 口座名義 */
    @Column(name = "account_nm")
    private String accountNm;

    /** 開設日 */
    @Column(name = "open_date")
    private LocalDate openDate;

    /** ステータス */
    @Column(name = "status")
    private String status;

    /** メモ */
    @Column(name = "memo")
    private String memo;

    /** 作成日 */
    @CreatedDate
    @Column(name = "created_at", updatable = true)
    private LocalDateTime createdAt;

    /** 更新日 */
    @LastModifiedDate
    @Column(name = "updated_at")
    public LocalDateTime gupdatedAt;

}
