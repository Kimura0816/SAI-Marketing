package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    /** 会社ID */
    @JsonProperty("companyCd")
    private String companyCd;
    /** 会社名 */
    @JsonProperty("companyName")
    private String companyName;
    /** 権限 */
    @JsonProperty("auth")
    private String auth;
    /** 企業URL */
    @JsonProperty("companyUrl")
    private String companyUrl;
    /** 特商URL */
    @JsonProperty("specialSalesUrl")
    private String specialSalesUrl;
    /** プラポリURL */
    @JsonProperty("puraporiUrl")
    private String puraporiUrl;
    /** 連絡先メールアドレス */
    @JsonProperty("email")
    private String email;
    /** 連絡先電話番号 */
    @JsonProperty("tel")
    private String tel;
}
