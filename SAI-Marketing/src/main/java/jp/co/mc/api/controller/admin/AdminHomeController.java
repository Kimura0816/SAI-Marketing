package jp.co.mc.api.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class AdminHomeController {
    @GetMapping("/admin-home")
    public String home(Model model) {
        return "admin/admin-home";
    }
}
