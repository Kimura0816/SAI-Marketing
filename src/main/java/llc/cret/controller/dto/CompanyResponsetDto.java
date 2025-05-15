package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * インポート結果.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class
CompanyResponsetDto {

    @JsonProperty("result")
    private List<CompanyDto> result;

    @JsonProperty("msg")
    private String message;

}
