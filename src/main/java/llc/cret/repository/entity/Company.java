package llc.cret.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 会社.
 */
@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Company {

    /** 会社CD */
    @Id
    @Column(name = "company_cd")
    private String companyCd;

    /** パスワード */
    @Column(name = "password")
    private String password;

    /** 会社名 */
    @Column(name = "company_name")
    private String companyName;

    /** 権限 */
    @Column(name = "auth")
    private String auth;

    /** 企業URL */
    @Column(name = "company_url")
    private String companyUrl;

    /** 特商URL */
    @Column(name = "special_sales_url")
    private String specialSalesUrl;

    /** プラポリURL */
    @Column(name = "purapori_url")
    private String puraporiUrl;

    /** 連絡先メールアドレス */
    @Column(name = "email")
    private String email;

    /** 連絡先電話番号 */
    @Column(name = "tel")
    private String tel;

}
