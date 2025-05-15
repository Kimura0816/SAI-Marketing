package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    /** 商品CD （自動採番） */
    @Id
    @JsonProperty("productCd")
    private String productCd;
    /** 商品名 */
    @JsonProperty("productNm")
    String productNm;
    /** 販売会社コード */
    @JsonProperty("salesCompanyCd")
    String salesCompanyCd;
    /** 販売価格 */
    @JsonProperty("price")
    String price;
    /** 支払期間（日）  営業日 */
    @JsonProperty("paymentPeriod")
    String paymentPeriod;
    /** SLURL（セールスレター） */
    @JsonProperty("surl")
    String surl;
    /** 規約URL */
    @JsonProperty("agreementUrl")
    String agreementUrl;
    /** クーリングオフ説明 */
    @JsonProperty("coolingOffPeriodExplanation")
    String coolingOffPeriodExplanation;
    /** クーリングオフページURL（メール） */
    @JsonProperty("coolingOffPeriodUrl")
    String coolingOffPeriodUrl;
    /** 申込確認情報 住所 */
    @JsonProperty("dispAddress")
    String dispAddress;
    /** 申込確認情報 氏名 */
    @JsonProperty("dispNm")
    String dispNm;
    /** 申込確認情報 年齢 */
    @JsonProperty("dispAge")
    String dispAge;
    /** 申込確認情報  職業 */
    @JsonProperty("dispJob")
    String dispJob;
    /** 申込確認情報 電話番号 */
    @JsonProperty("dispTel")
    String dispTel;
    /** 申込確認情報 メールアドレス */
    @JsonProperty("dispEmail")
    String dispEmail;

}
