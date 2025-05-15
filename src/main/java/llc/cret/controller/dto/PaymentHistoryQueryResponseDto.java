package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 入金履歴検索応答.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentHistoryQueryResponseDto {

    /** 検索結果 */
    @JsonProperty("result")
    List<PaymentHistoryDto> result;

}
