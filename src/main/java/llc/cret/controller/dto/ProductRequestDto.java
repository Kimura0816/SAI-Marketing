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
public class ProductRequestDto {

    @JsonProperty("form")
    private ProductDto form;

}
