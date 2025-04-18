package jp.co.mc.api.controller.sign;

import jp.co.mc.api.model.SignInForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class SignInController {
    @GetMapping("/")
    public String init(Model model) {
        model.addAttribute("signInForm", SignInForm.builder().build());
        //login.htmlに画面遷移
        log.info("init login");
        return "sign/sign-in";
    }

    @PostMapping("/sign-in")
    public String doLogin(Model model) {
        //login.htmlに画面遷移
        return "redirect:/admin-home";
        // return "dashboard";
    }
}
