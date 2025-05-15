package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 口座DTO.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    /** 口座シーケンス */
    @JsonProperty("accountSeq")
    private String accountSeq;

    /** 支店CD */
    @JsonProperty("branch")
    private String branch;

    /** 口座番号 */
    @JsonProperty("account")
    private String account;

    /** 支店名 */
    @JsonProperty("branchNm")
    private String branchNm;

    /** 口座名義 */
    @JsonProperty("accountNm")
    private String accountNm;

    /** 開設日 */
    @JsonProperty("openDate")
    private String openDate;

    /** ステータス */
    @JsonProperty("status")
    private String status;

    /** メモ */
    @JsonProperty("memo")
    private String memo;
}
