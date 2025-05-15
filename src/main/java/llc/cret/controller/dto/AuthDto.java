package llc.cret.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
    /** 会社CD */
    private String companyCd;
    /** パスワード */
    private String password;
    /** 会社名 */
    private String companyName;
    /** 権限 */
    private String auth;
    /** 連絡先メールアドレス */
    private String email;
}
