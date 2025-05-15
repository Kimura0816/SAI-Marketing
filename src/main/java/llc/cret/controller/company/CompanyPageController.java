package llc.cret.controller.company;

import jakarta.servlet.http.HttpSession;
import llc.cret.constants.ViewlConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 管理ページ.
 */
@Slf4j
@Controller
public class CompanyPageController {

    /**
     * 企業ホーム.
     */
    @GetMapping("/company")
    public String home(Model model, HttpSession session) {
        return ViewlConst.PAGE_COMPANY;
    }

    /**
     * 商品管理.
     */
    @GetMapping("/company/products")
    public String products(Model model, HttpSession session) {
        return ViewlConst.PAGE_PRODUCTS;
    }

}
