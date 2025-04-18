package jp.co.mc.api.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ImportAccountForm {
    /** eMail */
    private String email;
    /** パスワード */
    private String passwd;
}
