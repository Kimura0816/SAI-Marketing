package llc.cret.controller.purchase;

import jakarta.servlet.http.HttpSession;
import llc.cret.constants.ViewlConst;
import llc.cret.controller.form.PurchaseEntryForm;
import llc.cret.controller.form.SignInForm;
import llc.cret.repository.entity.Product;
import llc.cret.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.thymeleaf.util.StringUtils;

import java.net.http.HttpRequest;
import java.util.Optional;

/**
 * 管理ページ.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class PurchasePageController {
    private final ProductService productService;

    /**
     * 購入.
     */
    @GetMapping("/purchase")
    public String init(
            @RequestParam(required=true) String companyCd,
            @RequestParam(required=true) String productCd,
            Model model) {

        Optional<Product> productOpt = productService.findById(productCd);
        if (productOpt.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        Product product = productOpt.get();
        if (!StringUtils.equals(product.getSalesCompanyCd(), companyCd)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        model.addAttribute(ViewlConst.FORM_SPURCHASE_ENTRY,
                PurchaseEntryForm.builder()
                        .productCd(productCd)
                        .companyCd(companyCd)
                        .productNm(product.getProductNm())
                        .price(String.valueOf(product.getPrice()))
                        .paymentPeriod(String.valueOf(product.getPaymentPeriod()))
                        .surl(product.getSurl())
                        .agreementUrl(product.getAgreementUrl())
                        .coolingOffPeriodExplanation(product.getCoolingOffPeriodExplanation())
                        .coolingOffPeriodUrl(product.getCoolingOffPeriodUrl())
                        .dispAddress(product.getDispAddress())
                        .dispNm(product.getDispNm())
                        .dispAge(product.getDispAge())
                        .dispJob(product.getDispJob())
                        .dispTel(product.getDispTel())
                        .dispEmail(product.getDispEmail())
                        .build());
        return ViewlConst.PAGE_PURCHASE_ENTRY;
    }

    /**
     * 購入申し込み.
     */
    @PostMapping("/purchase/entry")
    public String entry(PurchaseEntryForm model) {

        return ViewlConst.PAGE_PURCHASE_ENTRY;
    }

}
