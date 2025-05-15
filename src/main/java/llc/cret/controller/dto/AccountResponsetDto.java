package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 口座応答.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponsetDto {

    @JsonProperty("result")
    private List<AccountDto> result;

    @JsonProperty("msg")
    private String message;

}
