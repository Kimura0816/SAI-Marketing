package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountImportResponseDto {

    /** 登録口座 */
    @JsonProperty("imported")
    private List<AccountDto> imported;

    /** エラーデータ */
    @JsonProperty("rejected")
    private List<ImportResultDto> rejected;


}
