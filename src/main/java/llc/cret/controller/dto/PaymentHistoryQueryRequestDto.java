package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 入金履歴検索要求.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentHistoryQueryRequestDto {

    /** 入金日（from） */
    @JsonProperty("from")
    String from;

    /** 入金日（to） */
    @JsonProperty("to")
    String to;

    /** 支店CD */
    @JsonProperty("branch")
    String branch;

    /** 口座番号 */
    @JsonProperty("account")
    String account;

    /** 振込元 */
    @JsonProperty("transferSource")
    String transferSource;
}
