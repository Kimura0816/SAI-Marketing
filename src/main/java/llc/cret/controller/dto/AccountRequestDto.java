package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 口座要求DTO.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDto {

    @JsonProperty("form")
    private AccountDto form;

}
