package llc.cret.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 口座.
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "payment_history")
public class PaymentHistory {

    /** 履歴番号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_no")
    private Integer historyNo;

    /** 入金日 */
    @Column(name = "deposit_date")
    private LocalDate depositDate;

    /** 支店CD */
    @Column(name = "branch")
    private String branch;

    /** 口座番号 */
    @Column(name = "account")
    private String account;

    /** 振込元 */
    @Column(name = "transfer_source")
    private String transferSource;

    /** 出金金額(円) */
    @Column(name = "withdrawal_amount")
    private Integer withdrawalAmount;

    /** 入金金額(円) */
    @Column(name = "deposit_amount")
    private Integer depositAmount;

    /** 残高(円) */
    @Column(name = "balance")
    private Integer balance;

    /** メモ */
    @Column(name = "memo")
    private String memo;

}
