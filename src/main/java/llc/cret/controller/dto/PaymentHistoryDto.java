package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 入金履歴.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentHistoryDto {

    /** 履歴番号 */
    @JsonProperty("historyNo")
    int historyNo;
    /** 入金日 */
    @JsonProperty("depositDate")
    String depositDate;
    /** 支店CD */
    @JsonProperty("branch")
    String branch;
    /** 口座番号 */
    @JsonProperty("account")
    String account;
    /** 振込元 */
    @JsonProperty("transferSource")
    String transferSource;
    /** 出金金額(円) */
    @JsonProperty("withdrawalAmount")
    String withdrawalAmount;
    /** 入金金額(円) */
    @JsonProperty("depositAmount")
    String depositAmount;
    /** 残高(円) */
    @JsonProperty("balance")
    String balance;
    /** メモ */
    @JsonProperty("memo")
    String memo;
}
