package llc.cret.controller.form;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignInForm {
    /** 会社CD */
    private String companyCd;
    /** パスワード */
    private String passwd;
}
