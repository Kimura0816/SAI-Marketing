package llc.cret.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 商品応答.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponsetDto {

    @JsonProperty("result")
    private List<ProductDto> result;

    @JsonProperty("msg")
    private String message;

}
