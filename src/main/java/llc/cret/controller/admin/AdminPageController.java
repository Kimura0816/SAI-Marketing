package llc.cret.controller.admin;

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
public class AdminPageController {

    /**
     * 管理者ホーム.
     */
    @GetMapping("/admin")
    public String home(Model model, HttpSession session) {
        return ViewlConst.PAGE_ADMIN;
    }

    /**
     * 口座管理.
     */
    @GetMapping("/admin/account")
    public String initAccount(Model model, HttpSession session) {
        return ViewlConst.PAGE_ADMIN_ACCOUNT;
    }

    /**
     * 入金管理.
     */
    @GetMapping("/admin/payment")
    public String initPayment(Model model, HttpSession session) {
        return ViewlConst.PAGE_ADMIN_PAYMENT;
    }

    /**
     * 会社管理.
     */
    @GetMapping("/admin/company")
    public String initCompany(Model model, HttpSession session) {
        return ViewlConst.PAGE_ADMIN_COMPANY;
    }

}
