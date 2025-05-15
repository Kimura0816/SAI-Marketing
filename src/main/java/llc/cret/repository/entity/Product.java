package llc.cret.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品.
 */
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {
    /** 商材CD （自動採番） */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_cd")
    private int productCd;
    /** 商材名 */
    @Column(name = "product_nm")
    String productNm;
    /** 販売会社コード */
    @Column(name = "sales_company_cd")
    String salesCompanyCd;
    /** 販売価格 */
    @Column(name = "price")
    int price;
    /** 支払期間（日）  ？営業日 */
    @Column(name = "payment_period")
    int paymentPeriod;
    /** SLURL（セールスレター） */
    @Column(name = "surl")
    String surl;
    /** 規約URL */
    @Column(name = "agreement_url")
    String agreementUrl;
    /** クーリングオフ説明 */
    @Column(name = "cooling_off_period_explanation")
    String coolingOffPeriodExplanation;
    /** クーリングオフページURL（メール） */
    @Column(name = "cooling_off_period_url")
    String coolingOffPeriodUrl;
    /** 申込確認情報 住所 */
    @Column(name = "disp_address")
    String dispAddress;
    /** 申込確認情報 氏名 */
    @Column(name = "disp_nm")
    String dispNm;
    /** 申込確認情報 年齢 */
    @Column(name = "disp_age")
    String dispAge;
    /** 申込確認情報  職業 */
    @Column(name = "disp_job")
    String dispJob;
    /** 申込確認情報 電話番号 */
    @Column(name = "disp_tel")
    String dispTel;
    /** 申込確認情報 メールアドレス */
    @Column(name = "disp_email")
    String dispEmail;

}
