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
public class PaymentHistoryImportResponseDto {

    @JsonProperty("imported")
    List<ImportResultDto> imported;

    @JsonProperty("rejected")
    List<ImportResultDto> rejected;

}
