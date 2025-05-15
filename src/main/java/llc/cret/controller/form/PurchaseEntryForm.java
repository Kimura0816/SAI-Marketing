package llc.cret.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PurchaseEntryForm {
    /** 会社CD */
    private String companyCd;
    /** 商材CD */
    private String productCd;
    /** 商材名 */
    private String productNm;
    /** 販売価格 */
    private String price;
    /** 支払期間（日）  営業日 */
    private String paymentPeriod;
    /** SLURL（セールスレター） */
    private String surl;
    /** 規約URL */
    private String agreementUrl;
    /** クーリングオフ説明 */
    private String coolingOffPeriodExplanation;
    /** クーリングオフページURL（メール） */
    private String coolingOffPeriodUrl;
    /** 申込確認情報 住所 */
    private String dispAddress;
    /** 申込確認情報 氏名 */
    private String dispNm;
    /** 申込確認情報 年齢 */
    private String dispAge;
    /** 申込確認情報  職業 */
    private String dispJob;
    /** 申込確認情報 電話番号 */
    private String dispTel;
    /** 申込確認情報 メールアドレス */
    private String dispEmail;
}
