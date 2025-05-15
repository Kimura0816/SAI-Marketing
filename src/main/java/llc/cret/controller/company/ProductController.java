package llc.cret.controller.company;

import jakarta.servlet.http.HttpSession;
import llc.cret.constants.ViewlConst;
import llc.cret.controller.dto.*;
import llc.cret.repository.entity.Company;
import llc.cret.repository.entity.PaymentHistory;
import llc.cret.repository.entity.Product;
import llc.cret.service.PaymentHistoryQueryService;
import llc.cret.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 商材 Restコントローラ.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * 商材登録.
     * @param body
     * @return 会社情報.
     */
    @RequestMapping(value = "/rest/product", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<ProductResponsetDto> doRegist(@RequestBody ProductRequestDto body, HttpSession session) {

        AuthDto authDto = (AuthDto) session.getAttribute(ViewlConst.STORE_AUTH);

        Product product = toEntity(authDto, body.getForm());
        Product result = productService.regist(product);
        ProductResponsetDto res = ProductResponsetDto.builder()
                .result(Collections.singletonList(toDto(result))).build();

        return ResponseEntity.ok(res);
    }

    /**
     * 商材 作成.
     * @param authDto 権限情報
     * @param dto 商材入力情報
     * @return 商材
     */
    private Product toEntity(AuthDto authDto, ProductDto dto) {
        return Product.builder()
                .productNm(dto.getProductNm())
                .salesCompanyCd(authDto.getCompanyCd())
                .price(Integer.parseInt(dto.getPrice()))
                .paymentPeriod(Integer.parseInt(dto.getPaymentPeriod()))
                .surl(dto.getSurl())
                .agreementUrl(dto.getAgreementUrl())
                .coolingOffPeriodExplanation(dto.getCoolingOffPeriodExplanation())
                .coolingOffPeriodUrl(dto.getCoolingOffPeriodUrl())
                .dispAddress(dto.getDispAddress())
                .dispNm(dto.getDispNm())
                .dispAge(dto.getDispAge())
                .dispJob(dto.getDispJob())
                .dispTel(dto.getDispTel())
                .dispEmail(dto.getDispEmail())
                .build();
    }

    /**
     * 商材Dto 作成.
     * @param entity 商材情報
     * @return 商材Dto
     */
    private ProductDto toDto(Product entity) {
        return ProductDto.builder()
                .productCd(String.valueOf(entity.getProductCd()))
                .productNm(entity.getProductNm())
                .salesCompanyCd(entity.getSalesCompanyCd())
                .price(String.valueOf(entity.getPrice()))
                .paymentPeriod(String.valueOf(entity.getPaymentPeriod()))
                .surl(entity.getSurl())
                .agreementUrl(entity.getAgreementUrl())
                .coolingOffPeriodExplanation(entity.getCoolingOffPeriodExplanation())
                .coolingOffPeriodUrl(entity.getCoolingOffPeriodUrl())
                .dispAddress(entity.getDispAddress())
                .dispNm(entity.getDispNm())
                .dispAge(entity.getDispAge())
                .dispJob(entity.getDispJob())
                .dispTel(entity.getDispTel())
                .dispEmail(entity.getDispEmail())
                .build();
    }
}
