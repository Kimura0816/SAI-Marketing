package llc.cret.controller.sign;

import jakarta.servlet.http.HttpSession;
import llc.cret.constants.AuthConst;
import llc.cret.constants.ViewlConst;
import llc.cret.controller.dto.AuthDto;
import llc.cret.controller.form.SignInForm;
import llc.cret.repository.entity.Company;
import llc.cret.service.SignInService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static java.util.Objects.isNull;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SignInController {
    private final SignInService signInService;

    /**
     * インデックス.
     * @param model
     * @return 遷移先
     */
    @GetMapping("/")
    public String init(Model model) {
        model.addAttribute(ViewlConst.FORM_SIGN_IN, SignInForm.builder().build());
        return ViewlConst.PAGE_SIGN_IN;
    }

    /**
     * サインイン.
     * @param form 入力情報
     * @param session セッション情報
     * @return 遷移先
     */
    @PostMapping("/sign-in")
    public String doSignIn(SignInForm form, HttpSession session) {
        String companyCd = form.getCompanyCd();
        String passwd = form.getPasswd();
        Company company = signInService.signIn(companyCd, passwd);
        if (isNull(company)) {
            return ViewlConst.PAGE_SIGN_IN;
        }
        session.setAttribute(ViewlConst.STORE_AUTH, createAuth(company));
        if (AuthConst.ADMIN.equals(company.getAuth())) {
            return ViewlConst.REDIRECT_ADMIN;
        } else {
            return ViewlConst.REDIRECT_COMPANY;
        }
    }

    /**
     * サインアウト.
     * @param session セッション
     * @return 遷移先
     */
    @GetMapping("/sign-out")
    public String doSignOut(HttpSession session) {
        session.invalidate();
        return ViewlConst.REDIRECT_INDEX;
    }

    /**
     * 権限情報作成.
     * @param company 会社情報
     * @return 権限情報
     */
    private AuthDto createAuth(Company company) {
        return AuthDto.builder()
                .auth(company.getAuth())
                .email(company.getEmail())
                .companyCd(company.getCompanyCd())
                .companyName(company.getCompanyName())
                .password(company.getPassword())
                .build();
    }
}
