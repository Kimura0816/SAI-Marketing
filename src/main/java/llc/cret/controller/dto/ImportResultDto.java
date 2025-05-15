package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * インポート結果.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportResultDto {

    @JsonProperty("result")
    private String result;

    @JsonProperty("recordNumber")
    private long recordNumber;

    @JsonProperty("values")
    private String[] values;

}
