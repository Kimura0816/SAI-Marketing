package jp.co.mc.api.controller.admin;

import jp.co.mc.api.model.ImportAccountForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class AccountController {
    @GetMapping("/account")
    public String init(Model model) {
        model.addAttribute("importAccountForm", ImportAccountForm.builder().build());
        //login.htmlに画面遷移
        log.info("init login");
        return "admin/account";
    }

    @PostMapping("/import-account")
    public String doImport(Model model) {
        //login.htmlに画面遷移
        log.info("post login");
        return "admin/account";
    }
}
