package jp.co.mc.api.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CompanyController {
    @GetMapping("/company")
    public String init(Model model) {
       // model.addAttribute("signInForm", SignInForm.builder().build());
        //login.htmlに画面遷移
        log.info("init login");
        return "admin/company";
    }

    @PostMapping("/import-company")
    public String doLogin(Model model) {
        //login.htmlに画面遷移
        log.info("post login");
        return "admin/account";
    }
}
